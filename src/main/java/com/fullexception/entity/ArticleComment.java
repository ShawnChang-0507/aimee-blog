package com.fullexception.entity;

import java.util.Date;

public class ArticleComment {
    private Integer articleCommentId;

    private Integer articleId;

    private Integer userId;

    private String articleCommentContent;

    private Date createTime;

    public Integer getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Integer articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleCommentContent() {
        return articleCommentContent;
    }

    public void setArticleCommentContent(String articleCommentContent) {
        this.articleCommentContent = articleCommentContent == null ? null : articleCommentContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}