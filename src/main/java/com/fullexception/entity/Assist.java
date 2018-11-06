package com.fullexception.entity;

import java.util.Date;

public class Assist {
    private Integer assistId;

    private Integer articleId;

    private Integer discussId;

    private Integer visitorId;

    private Date createDate;

    public Integer getAssistId() {
        return assistId;
    }

    public void setAssistId(Integer assistId) {
        this.assistId = assistId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}