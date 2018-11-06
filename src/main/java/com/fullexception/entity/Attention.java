package com.fullexception.entity;

import java.util.Date;

public class Attention {
    private Integer attentionId;

    private Integer ownerVisitorId;

    private Integer attentionVisitonId;

    private Date createDate;

    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Integer getOwnerVisitorId() {
        return ownerVisitorId;
    }

    public void setOwnerVisitorId(Integer ownerVisitorId) {
        this.ownerVisitorId = ownerVisitorId;
    }

    public Integer getAttentionVisitonId() {
        return attentionVisitonId;
    }

    public void setAttentionVisitonId(Integer attentionVisitonId) {
        this.attentionVisitonId = attentionVisitonId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}