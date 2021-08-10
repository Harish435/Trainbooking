package com.hclproject.TrainTicket.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclproject.TrainTicket.Entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{

	List<TicketEntity> findByUserId(Integer uid);

}
