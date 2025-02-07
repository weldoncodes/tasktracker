package com.weldonyang;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String id;
    private String description;
    private TaskStatus status;
    private String createdAt;
    private String modifiedAt;
    private String deadline;
    private String startTime;


    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TaskStatus.NOT_STARTED;
        this.createdAt = getCurrentTimestamp();
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void updateDesription(String description) {
        this.description = description;
        this.modifiedAt = getCurrentTimestamp();
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void startTask() {
        this.status = TaskStatus.IN_PROGRESS;
    }

    public void completeTask() {
        this.status = TaskStatus.COMPLETED;
    }

    public void setDeadline(String deadline) {
        this.deadline=deadline;

    }

    public String getDeadline() {
        return this.deadline;
    }

    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
