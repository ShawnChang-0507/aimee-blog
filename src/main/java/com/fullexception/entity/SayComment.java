package com.fullexception.entity;

import java.util.Date;

public class SayComment {
    private Integer sayCommentId;

    private Integer sayId;

    private Integer userId;

    private Date createTime;

    private String sayCommentContent;

    public Integer getSayCommentId() {
        return sayCommentId;
    }

    public void setSayCommentId(Integer sayCommentId) {
        this.sayCommentId = sayCommentId;
    }

    public Integer getSayId() {
        return sayId;
    }

    public void setSayId(Integer sayId) {
        this.sayId = sayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSayCommentContent() {
        return sayCommentContent;
    }

    public void setSayCommentContent(String sayCommentContent) {
        this.sayCommentContent = sayCommentContent == null ? null : sayCommentContent.trim();
    }
}