package com.hclproject.TrainTicket.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.User;

public interface TicketService {

	TicketEntity booktickets(TicketEntity tickets);

	List<TicketEntity> getallTickets();

	TicketEntity getbyId(Integer ticketid);

	TicketEntity bookById(int uid, int tainid, int notickets, TicketEntity tickets);
}
