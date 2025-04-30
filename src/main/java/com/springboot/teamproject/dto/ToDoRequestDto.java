package com.springboot.teamproject.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ToDoRequestDto {
    private String userName;
    private String title;
    private String description;
    private boolean completed;

    public String getUserName() {
        return this.userName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ToDoRequestDto(userName=" + this.getUserName() +
                ", title=" + this.getTitle() +
                ", description=" + this.getDescription() +
                ", completed=" + this.isCompleted() + ")";
    }
}