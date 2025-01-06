package com.vhbchieu.todolist.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vhbchieu.todolist.config.NotPast;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Getter
public class TodoCreateDto {

    @Size(min = 1, max = 30)
    private String title;

    @Size(max = 100)
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotPast
    private Date date;
}
