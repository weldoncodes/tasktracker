package com.weldonyang;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String id;
    private String description;
    private TaskStatus status;
    private String deadline;
    private String createdAt;
    private String modifiedAt;
    private String priority;
    private String startTime;
    private String group;

    public Task(String description, String deadline) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TaskStatus.NOT_STARTED;
        this.deadline = deadline;
        this.createdAt = getCurrentTimestamp();
    }

/* Getters */
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public String getPriority() {
        return priority;
    }

    public String getStartTime() {
        return startTime;
    }

/* Setters */
    public void updateDescription(String description) {
        this.description = description;
        this.modifiedAt = getCurrentTimestamp();
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void updateDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void startTask() {
        this.status = TaskStatus.IN_PROGRESS;
    }

    public void completeTask() {
        this.status = TaskStatus.COMPLETED;
    }



    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
