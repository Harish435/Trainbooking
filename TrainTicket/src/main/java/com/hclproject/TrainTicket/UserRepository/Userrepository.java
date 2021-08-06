package com.hclproject.TrainTicket.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;

public interface Userrepository extends JpaRepository<User, Long>{

	

}
