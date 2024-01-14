package com.lumen.lumenflightmangement.api;

import com.lumen.lumenflightmangement.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandlerAdvice {
	private final Logger logger;

	public ApplicationExceptionHandlerAdvice() {
			this.logger = LoggerFactory.getLogger(this.getClass().getName());
	}



	@ExceptionHandler(InvalidAuthenticationException.class)
	public ResponseEntity<?> handlerInvalidEmailIdFormatException(InvalidAuthenticationException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> handlerInvalidEmailIdFormatException(InvalidCredentialsException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}

	@ExceptionHandler(InvalidEmailIdFormatException.class)
	public ResponseEntity<?> handlerInvalidEmailIdFormatException(InvalidEmailIdFormatException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}


	@ExceptionHandler(InvalidModileNumberFormatException.class)
	public ResponseEntity<?> handlerInvalidEmailIdFormatException(InvalidModileNumberFormatException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}
	@ExceptionHandler(InvalidRequestCanNotProcessesException.class)
	public ResponseEntity<?> handlerInvalidEmailIdFormatException(InvalidRequestCanNotProcessesException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handlerRecordNotFoundException(RecordNotFoundException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}
	@ExceptionHandler(RequestNotValidException.class)
	public ResponseEntity<?> handlerInvalidEmailIdFormatException(RequestNotValidException e){
		logger.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
	}
//	@ExceptionHandler(.class)
//	public ResponseEntity<?> handlerInvalidEmailIdFormatException( e){
//		logger.warn(e.getMessage());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
//	}
//	@ExceptionHandler(.class)
//	public ResponseEntity<?> handlerInvalidEmailIdFormatException( e){
//		logger.warn(e.getMessage());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
//	}
}