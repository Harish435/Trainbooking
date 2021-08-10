package com.hclproject.TrainTicket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hclproject.TrainTicket.Entity.Passengers;
import com.hclproject.TrainTicket.UserService.PassengerService;

@RestController
//@RequestMapping("/ticket")
public class PassengerController {
	
	/*@Autowired
	PassengerService passengerservice;

	@PostMapping
	public Passengers savepassenger(@RequestBody Passengers thepasseneger){
		return passengerservice.savepassenger(thepasseneger);
		
	}*/
}
