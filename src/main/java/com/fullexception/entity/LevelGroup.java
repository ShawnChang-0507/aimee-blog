package com.fullexception.entity;

public class LevelGroup {
    private Integer levelGroupId;

    private String name;

    public Integer getLevelGroupId() {
        return levelGroupId;
    }

    public void setLevelGroupId(Integer levelGroupId) {
        this.levelGroupId = levelGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}