package com.vhbchieu.todolist.exception.handler;

import com.vhbchieu.todolist.dto.response.AppResponse;
import com.vhbchieu.todolist.exception.TodoException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobalExceptionHandler {

    private HttpServletRequest request;

    @ExceptionHandler(value = Exception.class)
    AppResponse handle(Exception e) {
        log.error("Request id: {}, Exception: {}", request.getRequestId(), e.getMessage(), e);
        return new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(value = TodoException.class)
    AppResponse todoExceptionHandle(TodoException e){
        log.error("Request id: {}, TotoException: {}", request.getRequestId(), e.getMessage(), e);
        return new AppResponse(e.getCode(), e.getMessage());
    }
}
