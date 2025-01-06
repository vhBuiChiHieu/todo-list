package com.vhbchieu.todolist.service;

import com.vhbchieu.todolist.dto.request.TodoCreateDto;
import com.vhbchieu.todolist.dto.request.TodoUpdateDto;
import com.vhbchieu.todolist.dto.response.TodoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    TodoResponseDto addTodo(TodoCreateDto request);

    List<TodoResponseDto> getAll();

    TodoResponseDto getById(Long id);

    TodoResponseDto update(Long id, TodoUpdateDto request);
}
