package com.assignment.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="participant")
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="participant_uuid")
	private String participant_uuid;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nickname")
	private String nickName;
	
	//@Temporal(value= TemporalType.TIMESTAMP)
	@Column(name="last_seen")
	private LocalDateTime last_seen;
	public Participant()
	{
		
	}
	
	public Participant(String email, String nickName, LocalDateTime last_seen) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.last_seen = last_seen;
	}
	public String getParticipant_uuid() {
		return participant_uuid;
	}
	public void setParticipant_uuid(String participant_uuid) {
		this.participant_uuid = participant_uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public LocalDateTime getLast_seen() {
		return last_seen;
	}
	public void setLast_seen(LocalDateTime last_seen) {
		this.last_seen = last_seen;
	}
	
	@Override
	public String toString() {
		return "Participant [participant_uuid=" + participant_uuid + ", email=" + email + ", nickName=" + nickName
				+ ", last_seen=" + last_seen + "]";
	}
	
	
	
}
