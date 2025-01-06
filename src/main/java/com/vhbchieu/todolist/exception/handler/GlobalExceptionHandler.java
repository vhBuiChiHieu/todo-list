package com.vhbchieu.todolist.exception.handler;

import com.vhbchieu.todolist.dto.response.ErrorResponse;
import com.vhbchieu.todolist.exception.TodoException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ErrorResponse> handle(Exception e, HttpServletRequest request) {
        log.error("Request id: {}, Exception: {}", request.getRequestId(), e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(request.getRequestId(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Lỗi Hệ Thống");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(value = TodoException.class)
    ResponseEntity<ErrorResponse> todoExceptionHandle(TodoException e, HttpServletRequest request){
        log.error("Request id: {}, path: {}, TotoException: {}", request.getRequestId(), request.getRequestURI(), e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(request.getRequestId(), e.getCode(), request.getRequestURI(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
