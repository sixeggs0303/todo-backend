package com.example.todo.dto;

public class LabelRequest {
    private String content;
    private String color;

    public LabelRequest() {
    }

    public LabelRequest(String content, String color) {
        this.content = content;
        this.color = color;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
