package com.fullexception.entity;

import java.util.Date;

public class Attention {
    private Integer attentionId;

    private Integer hostId;

    private Integer hostAttentionId;

    private Date createDate;

    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getHostAttentionId() {
        return hostAttentionId;
    }

    public void setHostAttentionId(Integer hostAttentionId) {
        this.hostAttentionId = hostAttentionId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}