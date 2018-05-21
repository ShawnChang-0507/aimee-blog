package com.fullexception.entity;

import java.util.Date;

public class ChattingRecord {
    private Integer chattingRecordId;

    private Integer sendUserId;

    private Integer receiveUserId;

    private String chattingRecordContent;

    private Date sendTime;

    private Boolean readFlag;

    public Integer getChattingRecordId() {
        return chattingRecordId;
    }

    public void setChattingRecordId(Integer chattingRecordId) {
        this.chattingRecordId = chattingRecordId;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getChattingRecordContent() {
        return chattingRecordContent;
    }

    public void setChattingRecordContent(String chattingRecordContent) {
        this.chattingRecordContent = chattingRecordContent == null ? null : chattingRecordContent.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }
}