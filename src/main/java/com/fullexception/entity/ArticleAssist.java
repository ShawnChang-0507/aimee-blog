package com.fullexception.entity;

import java.util.Date;

public class ArticleAssist {
    private Integer articleAssist;

    private Integer articleId;

    private Integer userId;

    private Date createDate;

    public Integer getArticleAssist() {
        return articleAssist;
    }

    public void setArticleAssist(Integer articleAssist) {
        this.articleAssist = articleAssist;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}