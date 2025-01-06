package com.vhbchieu.todolist.service.impl;

import com.vhbchieu.todolist.dto.request.TodoCreateDto;
import com.vhbchieu.todolist.dto.request.TodoUpdateDto;
import com.vhbchieu.todolist.dto.response.TodoResponseDto;
import com.vhbchieu.todolist.entity.Todo;
import com.vhbchieu.todolist.exception.TodoException;
import com.vhbchieu.todolist.mapper.TodoMapper;
import com.vhbchieu.todolist.repos.TodoRepos;
import com.vhbchieu.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepos todoRepos;
    private final TodoMapper mapper;

    @Override
    public TodoResponseDto addTodo(TodoCreateDto request) {
        Todo newTodo = mapper.getToDoForm(request);
        todoRepos.save(newTodo);
        return mapper.getDtoFrom(newTodo);
    }

    @Override
    public List<TodoResponseDto> getAll() {
        return todoRepos.findAll().stream().map(mapper::getDtoFrom).toList();
    }

    @Override
    public TodoResponseDto getById(Long id) {
        Todo existTodo = todoRepos.findById(id).orElse(null);
        if (existTodo == null)
            throw new TodoException(404, "Không tìm thấy Todo id:" + id);
        return mapper.getDtoFrom(existTodo);
    }

    @Override
    public TodoResponseDto update(Long id, TodoUpdateDto request) {
        Todo existedTodo = todoRepos.findById(id).orElse(null);

        if (existedTodo == null)
            throw new TodoException(404, "Todo with id: " + id + " not found.");

        existedTodo.setTitle(request.getTitle());
        existedTodo.setDescription(request.getDescription());
        existedTodo.setDate(request.getDate());
        existedTodo.setCompleted(request.isCompleted());

        todoRepos.save(existedTodo);

        return mapper.getDtoFrom(existedTodo);
    }
}
