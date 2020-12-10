package com.example.todo.controller;


import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.mapper.TodoMapper;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoMapper todoMapper;

    @GetMapping
    public List<TodoResponse> getTodos() {
        return todoService.getTodos().stream().map(todo -> todoMapper.toResponse(todo)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable String id) throws TodoNotFoundException {
        return todoMapper.toResponse(todoService.getTodo(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse createTodo(@RequestBody TodoRequest todoRequest) {
        Todo todo = todoMapper.toEntity(todoRequest);
        return todoMapper.toResponse(todoService.createTodo(todo));
    }

    @PutMapping("/{id}")
    public TodoResponse updateTodo(@PathVariable String id, @RequestBody TodoRequest updatedTodoRequest) throws TodoNotFoundException {
        Todo updatedTodo = todoMapper.toEntity(updatedTodoRequest);
        return todoMapper.toResponse(todoService.updateTodo(id, updatedTodo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable String id) throws TodoNotFoundException {
        todoService.deleteTodo(id);
    }
}
