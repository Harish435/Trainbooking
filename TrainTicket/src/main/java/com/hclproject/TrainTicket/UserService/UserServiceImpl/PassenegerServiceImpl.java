package com.hclproject.TrainTicket.UserService.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclproject.TrainTicket.Entity.Passengers;
import com.hclproject.TrainTicket.UserRepository.PassengerRepository;
import com.hclproject.TrainTicket.UserService.PassengerService;
@Service
public class PassenegerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepository pasengerrepo;
	
	@Override
	public Passengers savepassenger(Passengers thepasseneger) {
		
		return pasengerrepo.save(thepasseneger);
	}

}
