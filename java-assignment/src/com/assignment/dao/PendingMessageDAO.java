package com.assignment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.controller.EncryptionDecryptionClass;
import com.assignment.entity.PendingMessage;

@Repository
public class PendingMessageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void getInstantMessage(PendingMessage pendingMessage) throws Exception
	{
		Session session=sessionFactory.getCurrentSession();
		pendingMessage.setMessage(EncryptionDecryptionClass.encrypt(pendingMessage.getMessage()));
		session.save(pendingMessage);
	}
	

    @Transactional
	public List<String> fetchPendingMessages(String participant_uuid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fetchPendingMessages");
		Session session=sessionFactory.getCurrentSession();
		Query<PendingMessage> query=session.createQuery("from PendingMessage where participant_uuid=:participant_uuid", PendingMessage.class);
		query.setParameter("participant_uuid", participant_uuid);
		List<PendingMessage> messages=query.getResultList();
		List<String> messageList=new ArrayList<>();
		for(PendingMessage p:messages)
		{
			messageList.add(EncryptionDecryptionClass.decrypt(p.getMessage()));
			
		}
		return messageList;
	}

    @Transactional
	public void deleteMessages(String participant_uuid) {
		// TODO Auto-generated method stub
    	Session session=sessionFactory.getCurrentSession();
		System.out.println(participant_uuid);
		Query theQuery=session.createQuery("delete from PendingMessage where participant_uuid=:participant_uuid");
		theQuery.setParameter("participant_uuid",participant_uuid);
		theQuery.executeUpdate();
	}
	
}
