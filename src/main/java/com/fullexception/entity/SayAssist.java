package com.fullexception.entity;

import java.util.Date;

public class SayAssist {
    private Integer sayAssistId;

    private Integer sayId;

    private Integer userId;

    private Date createDate;

    public Integer getSayAssistId() {
        return sayAssistId;
    }

    public void setSayAssistId(Integer sayAssistId) {
        this.sayAssistId = sayAssistId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}