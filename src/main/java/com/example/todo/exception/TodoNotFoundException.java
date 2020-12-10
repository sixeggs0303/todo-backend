package com.example.todo.exception;

import java.util.function.Supplier;

public class TodoNotFoundException extends Exception {
    public TodoNotFoundException() {
        super("Todo not found");
    }
}
