package com.example.todo.service;

import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    public void should_return_a_todo_when_get_todo_given_id() throws TodoNotFoundException {
        //given
        final Todo expected = new Todo();
        when(todoRepository.findById(any())).thenReturn(Optional.of(expected));

        //when
        final Todo actual = todoService.getTodo("");

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_throw_todo_not_found_exception_when_get_todo_given_wrong_id() {
        //when
        final TodoNotFoundException todoNotFoundException = assertThrows(TodoNotFoundException.class, () -> todoService.getTodo(""));

        //then
        assertEquals("Todo not found", todoNotFoundException.getMessage());
    }
}
