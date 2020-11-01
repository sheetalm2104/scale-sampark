package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment.dao.ParticipantDAO;
import com.assignment.dao.PendingMessageDAO;
import com.assignment.entity.Participant;
import com.assignment.entity.PendingMessage;

@Controller
public class ParticipantController {


@Autowired
private PendingMessageDAO pendinMessageDAO;

@Autowired
private ParticipantDAO participantDAO;

@GetMapping("/fetchParticipants")
public String fetchParticipants(Model theModel)
{   
	List<Participant> participants=participantDAO.getParticipants();
	theModel.addAttribute("participants", participants);
	return "participants-list";
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel)
{  
	Participant  participant=new Participant();
	theModel.addAttribute("participant", participant);
	return "register-form";
}

@PostMapping("/registerParticipant")
@ResponseBody
public String doRegistration(@ModelAttribute("participant") Participant participant)
{  
	String participant_uuid=participantDAO.doRegistration(participant);
	return  participant_uuid + " Added Successfully";
}

@GetMapping("/deRegister")
@ResponseBody
public String deleteParticipant(@RequestParam("participant_uuid") String participant_uuid)
{  
	pendinMessageDAO.deleteMessages(participant_uuid);
    participantDAO.deleteParticipant(participant_uuid);
	return "deleted successfully";
}

@PostMapping("/getMessage")
@ResponseBody
public String getIncomingMessage(@ModelAttribute("pendingMessage") PendingMessage pendingMessage)
{  
	try
	{
	pendinMessageDAO.getInstantMessage(pendingMessage);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return  "Message Sent Successfully";
}

@GetMapping("/fetchPendingMessage")
public String fetchPendingMessage(@RequestParam("participant_uuid") String participant_uuid, Model theModel)
{  
	try
	{   
		List<String> pendingMessages=pendinMessageDAO.fetchPendingMessages(participant_uuid);
		participantDAO.updateLastSeen(participant_uuid);
		theModel.addAttribute("messages", pendingMessages);
		//update last seen
	}
	catch(Exception e)
	{
		System.out.println("Exception caught");
	}
	return  "pending-messages-list";
}

@GetMapping("/showMessageForm")
public String showMessageForm(@RequestParam("participant_uuid") String participant_uuid, Model theModel)
{  
   PendingMessage msg=new PendingMessage();
   msg.setParticipant_uuid(participant_uuid);
   theModel.addAttribute("pendingMessage", msg);
	return  "get-instant-message";
}


}
