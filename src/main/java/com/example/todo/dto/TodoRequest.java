package com.example.todo.dto;

import java.util.ArrayList;
import java.util.List;

public class TodoRequest {
    private String text;
    private boolean done = false;
    private List<String> labelIds;

    public TodoRequest() {
    }

    public TodoRequest(String text, boolean done, List<String> labelIds) {
        this.text = text;
        this.done = done;
        this.labelIds = labelIds;
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

    public List<String> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<String> labelIds) {
        this.labelIds = labelIds;
    }
}
