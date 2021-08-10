package com.hclproject.TrainTicket.UserService;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;


public interface UserService {

	User saveusers(User user);
	
	User updateusers(Long id, User user);
	
	User getUserbyid(Long id);
	
	List<User> getallusers();
	
	void deleteUser(Long id);

	List<TicketEntity> getallticketsbyid(Integer uid);

	String Loginusers(String userName, String password);

	
	
	
}
