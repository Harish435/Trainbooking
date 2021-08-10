package com.hclproject.TrainTicket.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclproject.TrainTicket.Entity.Passengers;

public interface PassengerRepository extends JpaRepository<Passengers, Long> {

}
