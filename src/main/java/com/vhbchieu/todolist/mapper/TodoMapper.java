package com.vhbchieu.todolist.mapper;

import com.vhbchieu.todolist.dto.request.TodoCreateDto;
import com.vhbchieu.todolist.dto.response.TodoResponseDto;
import com.vhbchieu.todolist.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo getToDoForm(TodoCreateDto request){
        return Todo.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .date(request.getDate())
                .build();
    }

    public TodoResponseDto getDtoFrom(Todo todo){
        if (todo == null)
            return null;
        return TodoResponseDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .date(todo.getDate())
                .completed(todo.isCompleted())
                .build();
    }
}
