package luiz.augusto.userhandlingforanimelistproject.controllers.exception;

import luiz.augusto.userhandlingforanimelistproject.exceptions.EmailAlreadyInUseException;
import luiz.augusto.userhandlingforanimelistproject.exceptions.ObjectNotFoundException;
import luiz.augusto.userhandlingforanimelistproject.exceptions.TokenExpiredException;
import luiz.augusto.userhandlingforanimelistproject.exceptions.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request)
    {
        var error = new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<StandardError> tokenExpiredException(TokenExpiredException e, ServletRequest request)
    {
        var error = new StandardError(e.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<StandardError> wrongPasswordException(WrongPasswordException e, ServletRequest request)
    {
        var error = new StandardError(e.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ResponseEntity<StandardError> emailAlreadyInUseException(EmailAlreadyInUseException e,
                                                                    ServletRequest request)
    {
        var error = new StandardError(e.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
