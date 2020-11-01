package com.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pending_message")
public class PendingMessage {
  
	@Column
	private String participant_uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private int message_uuid;
	
	@Column
	private int message_type ;
	
	@Column
	private String message;
	
	

	public PendingMessage(String participant_uuid, int message_type, String message) {
		super();
		this.participant_uuid = participant_uuid;
		this.message_type = message_type;
		this.message = message;
	}
	public PendingMessage()
	{
		
	}

	public String getParticipant_uuid() {
		return participant_uuid;
	}
    
	public void setParticipant_uuid(String participant_uuid) {
		this.participant_uuid = participant_uuid;
	}

	public int getMessage_uuid() {
		return message_uuid;
	}

	public void setMessage_uuid(int message_uuid) {
		this.message_uuid = message_uuid;
	}

	public int getMessage_type() {
		return message_type;
	}

	public void setMessage_type(int message_type) {
		this.message_type = message_type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PendingMessage [participant_uuid=" + participant_uuid + ", message_uuid=" + message_uuid
				+ ", message_type=" + message_type + ", message=" + message + "]";
	}
	
	


}
