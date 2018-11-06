package com.fullexception.entity;

public class BlogLevel {
    private Integer blogLevelId;

    private Integer levelGroupId;

    private String name;

    private String integral;

    public Integer getBlogLevelId() {
        return blogLevelId;
    }

    public void setBlogLevelId(Integer blogLevelId) {
        this.blogLevelId = blogLevelId;
    }

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

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral == null ? null : integral.trim();
    }
}