package com.hclproject.TrainTicket.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Passengers implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long passengerId;
	private String passengerName;
	private int age;
	private Long userId;
	
	/*@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="passengers")
	private TicketEntity ticket;*/
	
	public Passengers() {
		
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

/*public TicketEntity getTicket() {
		return ticket;
	}

	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
	}
*/

	public Passengers(Long passengerId, String passengerName, int age, Long userId) {
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.age = age;
		this.userId = userId;
	}
}
