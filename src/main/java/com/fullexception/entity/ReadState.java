package com.fullexception.entity;

public class ReadState {
    private Integer readStateId;

    private String name;

    public Integer getReadStateId() {
        return readStateId;
    }

    public void setReadStateId(Integer readStateId) {
        this.readStateId = readStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}