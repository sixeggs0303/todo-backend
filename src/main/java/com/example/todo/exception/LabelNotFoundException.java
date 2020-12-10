package com.example.todo.exception;

public class LabelNotFoundException extends Exception{
    public LabelNotFoundException() {
        super("Label not found");
    }
}
