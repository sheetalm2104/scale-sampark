package com.assignment.dao;

import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.entity.Participant;

@Repository
public class ParticipantDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Participant> getParticipants()
	{
		Session session=sessionFactory.getCurrentSession();
		Query<Participant> query=session.createQuery("from Participant", Participant.class);
		List<Participant> participants=query.getResultList();
		return participants;
	}
	
	@Transactional
	public String doRegistration(Participant participant)
	{  
		Session session=sessionFactory.getCurrentSession();
		//long yourmilliseconds = System.currentTimeMillis();
		 //Date resultdate = new Date(yourmilliseconds);
		participant.setLast_seen(LocalDateTime.now());
		session.save(participant);
		return participant.getParticipant_uuid();
	}

	@Transactional
	public void deleteParticipant(String participant_uuid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		System.out.println(participant_uuid);
		Query theQuery=session.createQuery("delete from Participant where participant_uuid=:participant_uuid");
		theQuery.setParameter("participant_uuid",participant_uuid);
		theQuery.executeUpdate();

		
	}

	@Transactional
	public void updateLastSeen(String participant_uuid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		System.out.println(participant_uuid);
		Query theQuery=session.createQuery("update Participant set last_seen=now() where participant_uuid=:participant_uuid");
		theQuery.setParameter("participant_uuid",participant_uuid);
		theQuery.executeUpdate();
}
	
}
