package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTests {
    @InjectMocks
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Test
    public void should_return_all_todo_when_get_todos_given_todos() {
        //given
        final List<Todo> expected = new ArrayList<>();
        expected.add(new Todo());
        when(todoRepository.findAll()).thenReturn(expected);

        //when
        final List<Todo> actual = todoService.getTodos();

        //then
        assertEquals(expected, actual);
    }
}
