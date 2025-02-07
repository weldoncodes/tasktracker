package com.weldonyang;

import java.util.UUID;

public class Task {
    private String id;
    private String description;
    private TaskStatus status;


    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TaskStatus.NOT_STARTED;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void updateDesription(String description) {
        this.description = description;
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
}
