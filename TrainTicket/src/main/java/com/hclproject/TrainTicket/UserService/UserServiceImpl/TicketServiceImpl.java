package com.hclproject.TrainTicket.UserService.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hclproject.TrainTicket.CustomException.SeatNotValidException;
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
import com.hclproject.TrainTicket.UserService.UserService;

@Service
public class TicketServiceImpl implements TicketService {

	public TicketServiceImpl(TicketRepository ticketrepo) {
		this.ticketrepo = ticketrepo;
	}

	@Autowired
	TicketRepository ticketrepo;
	
	@Autowired
	PassengerRepository passengerrepo;
	
	@Autowired
	TrainService trainservice;
	
	@Autowired
	UserService userservice;
	
	
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
		Train train=trainservice.getUserbyid((long) tainid);
		//User user=userservice.getUserbyid((long) uid);
		
		if(train!=null) {
			int availableSeats=	train.getAvailablSeats();
			int cal=trainservice.getUserbyid((long) tainid).getAvailablSeats()-notickets;
			//System.out.println("gggg"+cal);
			if(notickets <= 0 || notickets > availableSeats) {
				throw new SeatNotValidException("Please Enter Valid Number of Seats");
			}else {
				trainservice.updatetrain((long) tainid).setAvailablSeats(cal);
				tickets.setUserId(uid);
				tickets.setTrainId(tainid);
				tickets.setDto(trainservice.getUserbyid((long) tainid).getDestination());
				tickets.setSfrom(trainservice.getUserbyid((long) tainid).getSource());
				List<Passengers>p=tickets.getPassengers();
				for (Passengers passengers : p) {
					passengers.setUserId((long) uid);
				}
			}
			return ticketrepo.save(tickets);
		}
		System.out.println("error");
		return null;
		
	}

}
