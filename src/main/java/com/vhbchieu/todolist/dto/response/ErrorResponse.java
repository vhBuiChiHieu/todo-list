package com.vhbchieu.todolist.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@JsonPropertyOrder({"requestId", "status", "timestamp", "path", "error", "message"})
public class ErrorResponse {
    private String requestId;
    private int status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date timestamp;
    private String path;
    private String error;
    private String message;

    public ErrorResponse(String requestId, int status, String path, String error, String message) {
        this.requestId = requestId;
        this.status = status;
        this.timestamp = new Date();
        this.path = path;
        this.error = error;
        this.message = message;
    }
}
