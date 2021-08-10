package com.hclproject.TrainTicket.Entity;
/**
 * 
 * Train Entity class
 * 
 * */

/**
 * 
 * @author Harish
 * 
 * */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
public class Train {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainId;
	

	private int trainNumber;
	
	
	private String trainName;
	
	
	private String source;
	

	private String destination;
	
	
	private int availablSeats;
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
/*	@ManyToOne
	@JoinColumn(name="train")
	private User user;*/
	
	public Train() {
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getAvailablSeats() {
		return availablSeats;
	}

	public void setAvailablSeats(int availablSeats) {
		this.availablSeats = availablSeats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Train(Long trainId, int trainNumber, String trainName, String source, String destination, int availablSeats, Date date) {
		this.trainId = trainId;
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.availablSeats = availablSeats;
		this.date = date;
	}
}
