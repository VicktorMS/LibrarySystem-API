package vicktorms.br.infnet.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
		return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
		
	}
	
	
}
