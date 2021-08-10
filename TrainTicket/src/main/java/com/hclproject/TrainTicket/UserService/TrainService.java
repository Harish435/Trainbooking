package com.hclproject.TrainTicket.UserService;

import java.util.Date;
import java.util.List;

import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;

public interface TrainService {

	Train saveTrain(Train thetrain);

	List<Train> getByNames(String source, String destination,String date);

	List<Train> getBydate(String date);
	
	List<Train> getalltrain();



	Train updatetrain(Long trainid);

	Train getUserbyid(Long trainid);
	
	

	/*Train gettrainbyid(Long uid);*/
}
