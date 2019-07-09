package com.huiyong.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huiyong.model.Message;

@ControllerAdvice
public class MyExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	
    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public ResponseEntity<?> handleMySQLIntegrityConstraintViolationException(Exception e) {
    	logger.warn("值重复：" + e.getMessage());
    	Message m = new Message();
    	m.setError("值重复");
        return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    }
}
