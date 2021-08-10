package com.hclproject.TrainTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hclproject.TrainTicket.Entity.Passengers;
import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserService.TicketService;

@RestController
@RequestMapping("/tickets")
public class Ticketcontroller {
	
	@Autowired
	TicketService ticketservice;

	/*@PostMapping("/booktickets")
	public TicketEntity booktickets(@RequestBody TicketEntity tickets){
		
		return ticketservice.booktickets(tickets);
	}*/
	
/*	@GetMapping("/gettickets")
	public List<TicketEntity> getTickets(){
		return ticketservice.getallTickets();
	}*/
	
	/*@GetMapping("/{ticketid}/getbyId")
	public TicketEntity getbyId(@PathVariable Integer ticketid){
		return ticketservice.getbyId(ticketid);
		
	}*/
	
	@PostMapping()
	public TicketEntity booktickets(@RequestParam int uid, @RequestParam int tainid,@RequestParam int notickets,@RequestBody TicketEntity tickets){
		return ticketservice.bookById(uid,tainid,notickets,tickets);
	}
	
}
