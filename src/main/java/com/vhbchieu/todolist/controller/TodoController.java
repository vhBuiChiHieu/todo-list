package com.vhbchieu.todolist.controller;

import com.vhbchieu.todolist.dto.request.TodoCreateDto;
import com.vhbchieu.todolist.dto.request.TodoUpdateDto;
import com.vhbchieu.todolist.dto.response.TodoResponseDto;
import com.vhbchieu.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<TodoResponseDto> addTodo(@RequestBody @Validated TodoCreateDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.addTodo(request));
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoResponseDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getById(id));
    }

    @PutMapping("/{id}")
    public TodoResponseDto update(@PathVariable(value = "id") Long id, @RequestBody TodoUpdateDto request){
        return todoService.update(id, request);
    }
}