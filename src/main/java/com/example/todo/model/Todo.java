package com.example.todo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
public class Todo {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String text;
    private boolean done;
    private List<String> labelIds = new ArrayList<>();

    public Todo() {
    }

    public Todo(String id, String text, boolean done, List<String> labelIds) {
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

    public List<String> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<String> labelIds) {
        this.labelIds = labelIds;
    }
}
