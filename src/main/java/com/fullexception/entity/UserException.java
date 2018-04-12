package com.fullexception.entity;

import java.util.Date;

public class UserException {
    private Integer exceptionId;

    private String exceptionName;

    private String exceptionContent;

    private String exceptionParentPosition;

    private String exceptionChildPosition;

    private String exceptionIp;

    private Date exceptionDate;

    public Integer getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(Integer exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName == null ? null : exceptionName.trim();
    }

    public String getExceptionContent() {
        return exceptionContent;
    }

    public void setExceptionContent(String exceptionContent) {
        this.exceptionContent = exceptionContent == null ? null : exceptionContent.trim();
    }

    public String getExceptionParentPosition() {
        return exceptionParentPosition;
    }

    public void setExceptionParentPosition(String exceptionParentPosition) {
        this.exceptionParentPosition = exceptionParentPosition == null ? null : exceptionParentPosition.trim();
    }

    public String getExceptionChildPosition() {
        return exceptionChildPosition;
    }

    public void setExceptionChildPosition(String exceptionChildPosition) {
        this.exceptionChildPosition = exceptionChildPosition == null ? null : exceptionChildPosition.trim();
    }

    public String getExceptionIp() {
        return exceptionIp;
    }

    public void setExceptionIp(String exceptionIp) {
        this.exceptionIp = exceptionIp == null ? null : exceptionIp.trim();
    }

    public Date getExceptionDate() {
        return exceptionDate;
    }

    public void setExceptionDate(Date exceptionDate) {
        this.exceptionDate = exceptionDate;
    }
}