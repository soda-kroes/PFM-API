package com.rupp.java.PFM_API.controller;


import com.rupp.java.PFM_API.dto.response.StatusResponse;
import com.rupp.java.PFM_API.exception.AlreadyExistException;
import com.rupp.java.PFM_API.exception.BadRequestException;
import com.rupp.java.PFM_API.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StatusResponse> handleGlobalException(Exception ex) {
        StatusResponse response = new StatusResponse();
        response.setErrCode(500);
        response.setErrMsg(ex.getMessage());
        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<StatusResponse> handleAlreadyExistException(AlreadyExistException ex) {
        StatusResponse response = new StatusResponse();
        response.setErrCode(409);
        response.setErrMsg(ex.getMessage());
        return ResponseEntity.status(409).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StatusResponse> handleNotFoundException(NotFoundException ex) {
        StatusResponse response = new StatusResponse();
        response.setErrCode(404);
        response.setErrMsg(ex.getMessage());
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StatusResponse> handleBadRequestException(BadRequestException ex) {
        StatusResponse response = new StatusResponse();
        response.setErrCode(400);
        response.setErrMsg(ex.getMessage());
        return ResponseEntity.status(400).body(response);
    }
}
