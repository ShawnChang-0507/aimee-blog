package com.fullexception.entity;

import java.util.Date;

public class HeadImg {
    private Integer headImgId;

    private Integer userId;

    private String headImg;

    private Date createDate;

    private Integer state;

    public Integer getHeadImgId() {
        return headImgId;
    }

    public void setHeadImgId(Integer headImgId) {
        this.headImgId = headImgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}