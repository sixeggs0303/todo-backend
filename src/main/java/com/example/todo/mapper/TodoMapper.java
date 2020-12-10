package com.example.todo.mapper;

import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.model.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public Todo toEntity(TodoRequest todoRequest) {
        Todo todo = new Todo();

        BeanUtils.copyProperties(todoRequest, todo);

        return todo;
    }

    public TodoResponse toResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();

        BeanUtils.copyProperties(todo, todoResponse);

        return todoResponse;
    }
}
