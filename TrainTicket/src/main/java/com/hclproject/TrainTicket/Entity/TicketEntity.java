package com.hclproject.TrainTicket.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hclproject.TrainTicket.Utils.DateUtils;

@Entity

public class TicketEntity {

	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketId;
	
	private int ticketNumber;
	
	private int userId;
	
	private Date dateofJouney;
	
	private Date dateofBooking;
	
	private double price;
	
	private int trainId;
	
	private String Sfrom;
	
	private String Dto;
	
	@OneToMany(targetEntity=Passengers.class,cascade=CascadeType.ALL)
	@JoinColumn(name="p_fk",referencedColumnName="ticketId")
	private List<Passengers> passengers;



	
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateofJouney() {
		return dateofJouney;
	}

	public void setDateofJouney(Date dateofJouney) {
		this.dateofJouney = dateofJouney;
	}

	public Date getDateofBooking() {
		return dateofBooking;
	}

	public void setDateofBooking(Date dateofBooking) {
		this.dateofBooking = dateofBooking;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSfrom() {
		return Sfrom;
	}

	public void setSfrom(String sfrom) {
		Sfrom = sfrom;
	}

	public String getDto() {
		return Dto;
	}

	public void setDto(String dto) {
		Dto = dto;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

	public TicketEntity(int ticketId, int ticketNumber, int userId, double price, int trainId, String sfrom, String dto, List<Passengers> passengers) {
		this.ticketId = ticketId;
		this.ticketNumber = ticketNumber;
		this.userId = userId;
		this.price = price;
		this.trainId = trainId;
		Sfrom = sfrom;
		Dto = dto;
		this.passengers = passengers;
	}
}
