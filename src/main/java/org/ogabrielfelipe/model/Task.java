package org.ogabrielfelipe.model;

import java.util.ArrayList;

public class Task {
    private String idTask;
    private String subject;
    private String description;
    private Boolean status;

    public Task(){}

    public Task(String subject, String description, Boolean status){
        this.subject = subject;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return idTask;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }





}
