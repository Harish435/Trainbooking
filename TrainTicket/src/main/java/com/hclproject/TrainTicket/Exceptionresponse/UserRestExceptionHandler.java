package com.hclproject.TrainTicket.Exceptionresponse;

/**
 * 
 * This Class is used to Handel the Global Exception
 * 
 * */

/**
 * @author Harish
 * 
 * */

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hclproject.TrainTicket.CustomException.NotaStringException;
import com.hclproject.TrainTicket.CustomException.SeatNotValidException;
import com.hclproject.TrainTicket.CustomException.UserNotFoundException;
import com.hclproject.TrainTicket.CustomException.UseralreadyExist;
import com.hclproject.TrainTicket.CustomException.userNotRegisterdException;

@RestControllerAdvice
public class UserRestExceptionHandler {

	/**
	 * 
	 * @param userNotFoundException it Extends Runtime Exception
	 * @param UserErrorResponse entity class for showing or displaying Message
	 * @return error body along with Httpstatus
	 * */
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc){
		
		UserErrorResponse error=new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UseralreadyExist exc){
		
		UserErrorResponse error=new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * 
	 * @param exc argument for handling Generic exception
	 * @return error body along with Httpstatus
	 * 
	 * */
	/*
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception exc){
		UserErrorResponse error=new UserErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("BAD Request.... ALLOWED ONLY Intger Format!! ");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}*/
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
	
	
	/**
	 * 
	 * @param exc argument for handling Numeric exception
	 * @return error body along with Httpstatus
	 * 
	 * */
	
	@ExceptionHandler
	public ResponseEntity<StringErrorResponse> handleException(NotaStringException exc){
		StringErrorResponse error=new StringErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("BAD Request.... ALLOWED ONLY Strings for Source And destination ");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StringErrorResponse> handleException(userNotRegisterdException exc){
		StringErrorResponse error=new StringErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StringErrorResponse> handleException(SeatNotValidException exc){
		StringErrorResponse error=new StringErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
