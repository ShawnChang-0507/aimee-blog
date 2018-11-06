package com.fullexception.entity;

public class ArticleState {
    private Integer articleStateId;

    private String name;

    public Integer getArticleStateId() {
        return articleStateId;
    }

    public void setArticleStateId(Integer articleStateId) {
        this.articleStateId = articleStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}