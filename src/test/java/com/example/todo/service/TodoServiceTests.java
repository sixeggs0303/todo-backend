package com.example.todo.service;

import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
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
import static org.mockito.Mockito.*;

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

    @Test
    public void should_return_todo_when_create_todo_given_todo() {
        //given
        final Todo expected = new Todo();
        when(todoRepository.save(any())).thenReturn(expected);

        //when
        final Todo actual = todoService.createTodo(expected);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_updated_todo_when_updated_todo_given_todo_and_todo_id() throws TodoNotFoundException {
        //given
        final Todo expected = new Todo();
        when(todoRepository.existsById(any())).thenReturn(true);
        when(todoRepository.save(any())).thenReturn(expected);

        //when
        final Todo actual = todoService.updateTodo(expected.getId(), expected);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_throw_todo_not_found_exception_when_update_todo_given_wrong_id() {
        //when
        final TodoNotFoundException todoNotFoundException = assertThrows(TodoNotFoundException.class, () -> todoService.updateTodo("", new Todo()));

        //then
        assertEquals("Todo not found", todoNotFoundException.getMessage());
    }

    @Test
    public void should_invoke_repository_delete_when_delete_todo_given_todo_id() throws TodoNotFoundException {
        //given
        when(todoRepository.existsById(any())).thenReturn(true);

        //when
        todoService.deleteTodo("");

        //then
        verify(todoRepository, times(1)).deleteById("");
    }

    @Test
    public void should_throw_todo_not_found_exception_when_delete_todo_given_wrong_id() {
        //when
        final TodoNotFoundException todoNotFoundException = assertThrows(TodoNotFoundException.class, () -> todoService.deleteTodo(""));
        //then
        assertEquals("Todo not found", todoNotFoundException.getMessage());
    }
}
