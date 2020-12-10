package com.example.todo.dto;

import com.example.todo.model.Label;

import java.util.ArrayList;
import java.util.List;

public class TodoResponse {
    private String id;
    private String text;
    private boolean done;
    private List<Label> labels = new ArrayList<>();

    public TodoResponse() {
    }

    public TodoResponse(String id, String text, boolean done, List<Label> labels) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.labels = labels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
