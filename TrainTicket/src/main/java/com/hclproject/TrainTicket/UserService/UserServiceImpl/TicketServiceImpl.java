package com.hclproject.TrainTicket.UserService.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hclproject.TrainTicket.CustomException.UserNotFoundException;
import com.hclproject.TrainTicket.Entity.Passengers;
import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserRepository.PassengerRepository;
import com.hclproject.TrainTicket.UserRepository.TicketRepository;
import com.hclproject.TrainTicket.UserRepository.TrainRepository;
import com.hclproject.TrainTicket.UserService.TicketService;
import com.hclproject.TrainTicket.UserService.TrainService;

@Service
public class TicketServiceImpl implements TicketService {


	
	@Autowired
	TicketRepository ticketrepo;
	
	@Autowired
	PassengerRepository passengerrepo;
	
	@Autowired
	TrainService trainservice;
	
	
	@Override
	public TicketEntity booktickets(TicketEntity tickets) {
		
		return ticketrepo.save(tickets);
	}


	@Override
	public List<TicketEntity> getallTickets() {
		return ticketrepo.findAll();
	}


	@Override
	public TicketEntity getbyId(Integer ticketid) {
			Optional<TicketEntity> ticket=ticketrepo.findById(ticketid);
			if(ticket.isPresent()){
				return ticket.get();
			}
		
		
		return null;
	}


	/*@Override
	public TicketEntity bookById(int uid, TicketEntity tickets) {
		tickets.setUserId(uid);
		List<Passengers>p=tickets.getPassengers();
		for (Passengers passengers : p) {
			passengers.setUserId((long) uid);
		}
		return ticketrepo.save(tickets);
	}*/

	
	@Override
	public TicketEntity bookById(int uid, int tainid, int notickets,
			TicketEntity tickets) {
		int cal=trainservice.getUserbyid((long) tainid).getAvailablSeats()-notickets;
		//System.out.println("gggg"+cal);
		trainservice.updatetrain((long) tainid).setAvailablSeats(cal);
		tickets.setUserId(uid);
		tickets.setTrainId(tainid);
		List<Passengers>p=tickets.getPassengers();
		for (Passengers passengers : p) {
			passengers.setUserId((long) uid);
		}
		return ticketrepo.save(tickets);
	}

}
