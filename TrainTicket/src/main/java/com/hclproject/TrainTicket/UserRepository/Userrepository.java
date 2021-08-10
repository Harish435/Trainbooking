package com.hclproject.TrainTicket.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;

public interface Userrepository extends JpaRepository<User, Long>{

	List<User> findByUserNameAndPassWord(String userName, String password);


    Optional<User> findByEmail(String email);
}
