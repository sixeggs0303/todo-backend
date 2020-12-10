package com.example.todo.service;

import com.example.todo.exception.LabelNotFoundException;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private LabelService labelService;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(String id) throws TodoNotFoundException {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo updatedTodo) throws TodoNotFoundException, LabelNotFoundException {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException();
        }

        if (!updatedTodo.getLabelIds().stream().allMatch(labelService::labelExist)) {
            throw new LabelNotFoundException();
        }

        updatedTodo.setId(id);
        return todoRepository.save(updatedTodo);
    }

    public void deleteTodo(String id) throws TodoNotFoundException {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException();
        }
        todoRepository.deleteById(id);
    }
}
