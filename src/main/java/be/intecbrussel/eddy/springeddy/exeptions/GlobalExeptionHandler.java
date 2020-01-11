package be.intecbrussel.eddy.springeddy.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GuyDoesNotExist.class)
    public ResponseEntity<NoGuyWasFound> noGuyWasFound(Exception ex){

        NoGuyWasFound errorResponse = new NoGuyWasFound();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setError(ex.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());


        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
}
