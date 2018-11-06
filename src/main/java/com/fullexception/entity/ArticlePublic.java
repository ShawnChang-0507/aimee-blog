package com.fullexception.entity;

public class ArticlePublic {
    private Integer articlePublicId;

    private String name;

    public Integer getArticlePublicId() {
        return articlePublicId;
    }

    public void setArticlePublicId(Integer articlePublicId) {
        this.articlePublicId = articlePublicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}