package com.vhbchieu.todolist.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class TodoResponseDto {

    private Long id;
    private String title;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private boolean completed;
}
