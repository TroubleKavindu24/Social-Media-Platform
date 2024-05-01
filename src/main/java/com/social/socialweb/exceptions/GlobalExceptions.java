package com.social.socialweb.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {

    
    public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception ue, WebRequest req){

        return null;
    }
}
