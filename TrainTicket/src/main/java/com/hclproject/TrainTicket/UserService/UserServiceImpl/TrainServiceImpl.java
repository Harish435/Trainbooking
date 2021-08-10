package com.hclproject.TrainTicket.UserService.UserServiceImpl;

/**
 * 
 * This is Service class
 * 
 * */

/**
 * 
 * @author Harish
 * */

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclproject.TrainTicket.CustomException.NotaStringException;
import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserRepository.TrainRepository;
import com.hclproject.TrainTicket.UserRepository.Userrepository;
import com.hclproject.TrainTicket.UserService.TicketService;
import com.hclproject.TrainTicket.UserService.TrainService;
import com.hclproject.TrainTicket.UserService.UserService;
import com.hclproject.TrainTicket.Utils.DateUtils;
@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainRepository trainrepository;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	TicketService ticketservice;

	public TrainServiceImpl(TrainRepository trainrepository) {
		this.trainrepository = trainrepository;
	}

	/**
	 * Used to save Train Entity
	 * @param thetrain Entity of train
	 * 
	 * */
	
	@Override
	public Train saveTrain(Train thetrain) {
		
		return trainrepository.save(thetrain);
	}

	public List<Train> getalltrain(){
		return trainrepository.findAll();
	}
	
	/**
	 * 
	 * Used to get trains based on source,destination and date
	 * @param source Tells the source of the train
	 * @param destination tells the destination of the train
	 * @return returns the list of trains based on arguments 
	 * 
	 * */
	
	@Override
	public List<Train> getByNames(String source, String destination,String date)  {
		
		String sourceString = source;
		String destinationString=destination;
		boolean isNumericsource = sourceString.chars().allMatch( Character::isDigit );
		boolean isNumericdestination = destinationString.chars().allMatch( Character::isDigit );
		
		if(isNumericsource){
			throw new NotaStringException("Entry is Numeric");
		}else if(isNumericdestination){
			throw new NotaStringException("Entry is Numeric");
		}
		else{
			String theDateStr = date;
			Date theDate=null;
			try {
				theDate = DateUtils.parseDate(theDateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trainrepository.findBySourceAndDestinationAndDate(source,destination,theDate);
		}
		
	}

	@Override
	public List<Train> getBydate(String date) {
		String theDateStr = date;
		Date theDate=null;
		try {
			theDate = DateUtils.parseDate(theDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainrepository.findByDate(theDate);
	}

	@Override
	public Train updatetrain(Long trainid) {
	Train thetrain=getUserbyid(trainid);
		
		return saveTrain(thetrain);
	}

	@Override
	public Train getUserbyid(Long trainid) {
	Optional<Train> train=	trainrepository.findById(trainid);
	if(train.isPresent()){
		return train.get();
	}
		return null;
	}



	
}
