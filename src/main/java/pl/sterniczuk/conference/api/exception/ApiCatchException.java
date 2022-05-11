package pl.sterniczuk.conference.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pl.sterniczuk.conference.service.exception.AlreadyExistsException;
import pl.sterniczuk.conference.service.exception.LimitException;
import pl.sterniczuk.conference.service.exception.NotFoundException;

import java.util.Date;

@ControllerAdvice
public class ApiCatchException {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleAlreadyExistsException(AlreadyExistsException ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = LimitException.class)
    public ResponseEntity<ErrorMessage> handleLimitException(LimitException ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_ACCEPTABLE);
    }
}
