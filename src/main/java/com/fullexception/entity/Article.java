package com.fullexception.entity;

import java.util.Date;

public class Article {
    private Integer articleId;

    private Integer articleStateId;

    private Integer articlePublicId;

    private Integer authorId;

    private Integer sourceId;

    private Integer articleGroupId;

    private String articleTitle;

    private Date createDate;

    private String secondTitle;

    private String articleContent;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleStateId() {
        return articleStateId;
    }

    public void setArticleStateId(Integer articleStateId) {
        this.articleStateId = articleStateId;
    }

    public Integer getArticlePublicId() {
        return articlePublicId;
    }

    public void setArticlePublicId(Integer articlePublicId) {
        this.articlePublicId = articlePublicId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Integer articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle == null ? null : secondTitle.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}