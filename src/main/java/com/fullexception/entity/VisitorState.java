package com.fullexception.entity;

public class VisitorState {
    private Integer visitorStateId;

    private String name;

    public Integer getVisitorStateId() {
        return visitorStateId;
    }

    public void setVisitorStateId(Integer visitorStateId) {
        this.visitorStateId = visitorStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}