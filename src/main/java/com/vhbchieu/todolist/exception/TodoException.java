package com.vhbchieu.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TodoException extends RuntimeException{
    private final int code;
    private final String msg;

    @Override
    public String getMessage() {
        return this.msg;
    }
}
