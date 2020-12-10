package com.example.todo.mapper;

import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.model.Label;
import com.example.todo.model.Todo;
import com.example.todo.service.LabelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper {
    @Autowired
    private LabelService labelService;

    public Todo toEntity(TodoRequest todoRequest) {
        Todo todo = new Todo();

        BeanUtils.copyProperties(todoRequest, todo);

        return todo;
    }

    public TodoResponse toResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();

        BeanUtils.copyProperties(todo, todoResponse);

        List<Label> labels = new ArrayList<>();

        for (String labelId : todo.getLabelIds()) {
            try {
                labels.add(labelService.getLabel(labelId));
            } catch (Exception e) {
                // Skip not existing label
            }
        }

        todoResponse.setLabels(labels);

        return todoResponse;
    }
}
