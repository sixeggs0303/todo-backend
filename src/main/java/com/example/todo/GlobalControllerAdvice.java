package com.example.todo;

import com.example.todo.advice.ErrorResponse;
import com.example.todo.exception.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException.class)
    public ErrorResponse handleTodoNotFound(TodoNotFoundException exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }
}
