package com.fullexception.entity;

public class Discuss {
    private Integer discussId;

    private Integer visitorId;

    private Integer articleId;

    private Integer parentDiscussId;

    private Integer readStateId;

    private String content;

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentDiscussId() {
        return parentDiscussId;
    }

    public void setParentDiscussId(Integer parentDiscussId) {
        this.parentDiscussId = parentDiscussId;
    }

    public Integer getReadStateId() {
        return readStateId;
    }

    public void setReadStateId(Integer readStateId) {
        this.readStateId = readStateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}