package com.vhbchieu.todolist.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Getter
public class TodoUpdateDto {

    @Size(min = 1, max = 30)
    private String title;
    @Size(max = 100)
    private String description;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @NotNull
    private boolean completed;
}
