package com.hclproject.TrainTicket.Controller;

/**
 * 
 * The home controller is rest controller for Users
 * and autowired to servicelayer
 * 
 * */

/**
 * @author Harish
 * */


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserService.UserService;

@RestController
@RequestMapping("/users")
public class HomeController {

	@Autowired
	UserService userservice;
	
	/**
	 * save Users  and bookticket
	 * @param user get user from enducers
	 * @return returns user which is saved to db 
	 * 
	 * */
	@PostMapping("/userRegister")
	public User saveusers(@Valid @RequestBody User user){
		return userservice.saveusers(user);
	}
	
	
	
	@PutMapping("/update/{uid}")
	public User updateusers(@PathVariable Long uid,@RequestBody User user){
		return userservice.updateusers(uid, user);
	}
	
	@GetMapping("/getByid/{uid}")
	public User getUserbyid(@PathVariable Long uid){
		
		return userservice.getUserbyid(uid);
	}
	
	@GetMapping("/gettransactonByid/{uid}")
	public List<TicketEntity> getTicketrbyid(@RequestParam Integer uid){
		
		return userservice.getallticketsbyid(uid);
	}
	
	@GetMapping("/getallusers")
	public List<User> getall(){
		return userservice.getallusers();
	}
	
	@DeleteMapping("/delete/{uid}")
	public void deleteuser(@PathVariable Long uid){
		userservice.deleteUser(uid);
	}
	
}
