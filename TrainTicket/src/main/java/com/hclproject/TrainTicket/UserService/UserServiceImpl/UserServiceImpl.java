package com.hclproject.TrainTicket.UserService.UserServiceImpl;

/**
 * THis Class is Service Layer
 * 
 * */

/**
 * 
 * @author Harish
 * 
 * */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclproject.TrainTicket.CustomException.UserNotFoundException;
import com.hclproject.TrainTicket.CustomException.UseralreadyExist;
import com.hclproject.TrainTicket.CustomException.userNotRegisterdException;
import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserRepository.TicketRepository;
import com.hclproject.TrainTicket.UserRepository.TrainRepository;
import com.hclproject.TrainTicket.UserRepository.Userrepository;
import com.hclproject.TrainTicket.UserService.TicketService;
import com.hclproject.TrainTicket.UserService.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	Userrepository userrepo;
	
	@Autowired
	TrainRepository trainrepo;

	@Autowired
	TicketService ticketser;
	
	@Autowired
	TicketRepository ticketrepo;

	public UserServiceImpl(Userrepository userrepo) {
		this.userrepo = userrepo;
	}

	/**
 * used to save users
 * @param user argument of user entity
 * 
 * 
 * */


	
	@Override
	public User saveusers(User user) {
     Optional<User> users=userrepo.findByEmail(user.getEmail());
     if(users.isPresent()){
     	throw  new UseralreadyExist("User Already Exist!!");
	 }
     return userrepo.save(user);
	}
	
	/**
	 * 
	 * Used to update users
	 * @param id on which id need to update
	 * @param user entity of fields which need to update
	 * 
	 * @return Updated user entity
	 * */
	
	@Override
	public User updateusers(Long id, User user) {
		if(id >= getallusers().size() || id<0){
			throw new UserNotFoundException("The user Not found!!"+id);
		}else{
			User theuser=getUserbyid(id);
			theuser.setAge(user.getAge());
			theuser.setPhoneNumber(user.getPhoneNumber());
			theuser.setPassWord(user.getPassWord());
			return saveusers(theuser);
		}
	
	}

	/**
	 * 
	 * Get users based on id
	 * @param id based on which id need to fetch user
	 * @return entity based on id
	 * 
	 * */
	
	@Override
	public User getUserbyid(Long id) {
		if(id >= getallusers().size() || id<0){
			throw new UserNotFoundException("The user Not found!!"+id);
		}else{
			Optional<User> user=userrepo.findById(id);
			
			if(user.isPresent()){
				return user.get();
			}
		}
		return null;
	}
	/**
	 * 
	 * Used to fetch all users
	 * 
	 * */

	@Override
	public List<User> getallusers() {
		return userrepo.findAll();
	}

	/**
	 * Used to delete Users based on @param
	 * @param id 
	 * 
	 * */
	
	@Override
	public void deleteUser(Long id) {
		 userrepo.deleteById(id);
	}

	@Override
	public List<TicketEntity> getallticketsbyid(Integer uid) {
	
		return ticketrepo.findByUserId(uid);
	
	
	}

	@Override
	public String Loginusers(String userName, String password) {
		List<User> users= userrepo.findByUserNameAndPassWord(userName,password);
		if(users.isEmpty()) {
			throw new userNotRegisterdException("User Not Registered!!");
		}
		return "Login SuccesFul!";
	}

	

	

}
