package com.example.todo.exception;

public class TodoNotFoundException extends Exception {
    public TodoNotFoundException() {
        super("Todo not found");
    }
}
