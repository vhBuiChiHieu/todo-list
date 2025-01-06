package com.vhbchieu.todolist.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Getter
public class TodoCreateDto {

    @Size(min = 1, max = 30)
    private String title;

    @Size(max = 100)
    private String description;
    private Date date;
}
