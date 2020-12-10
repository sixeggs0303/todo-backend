package com.example.todo.dto;

import com.example.todo.model.Label;

import java.util.List;

public class TodoResponse {
    private String id;
    private String text;
    private boolean done;
    private List<Label> labelIds;

    public TodoResponse() {
    }

    public TodoResponse(String id, String text, boolean done, List<Label> labelIds) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.labelIds = labelIds;
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

    public List<Label> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<Label> labelIds) {
        this.labelIds = labelIds;
    }
}
