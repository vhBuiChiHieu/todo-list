package com.vhbchieu.todolist.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AppResponse extends ResponseEntity<AppResponse.Payload> {

    //tra ve cho put, patch, delete
    public AppResponse(int status, String message) {
        super(new Payload(status, message), HttpStatus.OK);
    }
    //get, post
    public AppResponse(int status, String message, Object data) {
        super(new Payload(status, message, data), HttpStatus.OK);
    }

    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Payload {
        private final int status;
        private final String message;
        private Object data;

        public Payload(int status, String message){
            this.status = status;
            this.message = message;
            this.data = null;
        }

        public Payload(int status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }
    }
}
