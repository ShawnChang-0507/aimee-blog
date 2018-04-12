package com.fullexception.entity;

public class ArticleGroup {
    private Integer articleGroupId;

    private String articleGroupName;

    public Integer getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Integer articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public String getArticleGroupName() {
        return articleGroupName;
    }

    public void setArticleGroupName(String articleGroupName) {
        this.articleGroupName = articleGroupName == null ? null : articleGroupName.trim();
    }
}