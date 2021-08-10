package com.hclproject.TrainTicket.UserRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Utils.DateUtils;

public interface TrainRepository extends JpaRepository<Train, Long> {

	List<Train> findBySourceAndDestinationAndDate(String source,String destination,Date theDate);

	List<Train> findByDate(Date theDate);

	/*List<Train> findBySourceAndDestinationAndDate(String source,
			String destination, Object theDateOfBirth);*/

}
