package com.hclproject.TrainTicket.Controller;

/**
 * 
 * The class Train controller is Restcontroller 
 * and is autowired with trainservice
 * 
 * 
 * */

/**
 * @author Harish
 * 
 * */

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserService.TrainService;

@RestController
public class TrainController {

	@Autowired
	TrainService trainservice;
	
	
	@PostMapping("/saveTrains")
	public Train saveTrain(@Valid @RequestBody Train thetrain){
		return trainservice.saveTrain(thetrain);
	}
	
	@GetMapping("/getBySourceandDestination")
	public List<Train> getByNames( @RequestParam String source, @RequestParam String destination,
			@RequestParam String date){
		
		return trainservice.getByNames(source, destination,date);
	}
	
	@GetMapping("/getByDate")
	public List<Train> getBydate(
			@RequestParam String date){
		return trainservice.getBydate(date);
	}
	
	/*@GetMapping("/gettrainbyuid/{uid}")
	public Train gettrainbyuid(@PathVariable Long uid){
		return trainservice.gettrainbyid(uid);
		
	}*/
	@PutMapping("/update/{trainid}")
	public Train updatetrain(@PathVariable Long trainid){
		return trainservice.updatetrain(trainid);
	}
	
	@GetMapping("/getByid/{trainid}")
	public Train gettrainbyid(@PathVariable Long trainid){
		
		return trainservice.getUserbyid(trainid);
	}
}
