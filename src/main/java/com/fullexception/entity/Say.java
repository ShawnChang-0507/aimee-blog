package com.fullexception.entity;

import java.util.Date;

public class Say {
    private Integer sayId;

    private Integer userId;

    private Integer sourceId;

    private Integer parentId;

    private String sayName;

    private Date createDate;

    private String sayPosition;

    private String sayWeather;

    private Integer sayState;

    private String sayContent;

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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getSayName() {
        return sayName;
    }

    public void setSayName(String sayName) {
        this.sayName = sayName == null ? null : sayName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSayPosition() {
        return sayPosition;
    }

    public void setSayPosition(String sayPosition) {
        this.sayPosition = sayPosition == null ? null : sayPosition.trim();
    }

    public String getSayWeather() {
        return sayWeather;
    }

    public void setSayWeather(String sayWeather) {
        this.sayWeather = sayWeather == null ? null : sayWeather.trim();
    }

    public Integer getSayState() {
        return sayState;
    }

    public void setSayState(Integer sayState) {
        this.sayState = sayState;
    }

    public String getSayContent() {
        return sayContent;
    }

    public void setSayContent(String sayContent) {
        this.sayContent = sayContent == null ? null : sayContent.trim();
    }
}