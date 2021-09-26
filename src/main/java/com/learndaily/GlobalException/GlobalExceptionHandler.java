package com.learndaily.GlobalException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.learndaily.exception.ErrorDetails;
import com.learndaily.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorDetails> handlerException(ResourceNotFoundException ex,WebRequest request)
{
		//ErrorDetails details=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		ErrorDetails details=new ErrorDetails();
		details.setTimestamp(new Date());
		details.setMessage(ex.getMessage());
		details.setDetails(request.getDescription(false));
	    return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
}
}
