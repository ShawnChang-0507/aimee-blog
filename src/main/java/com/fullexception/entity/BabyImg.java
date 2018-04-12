package com.fullexception.entity;

import java.util.Date;

public class BabyImg {
    private Integer babyImgId;

    private Integer babyInfoId;

    private String babyImgContent;

    private Date createDate;

    public Integer getBabyImgId() {
        return babyImgId;
    }

    public void setBabyImgId(Integer babyImgId) {
        this.babyImgId = babyImgId;
    }

    public Integer getBabyInfoId() {
        return babyInfoId;
    }

    public void setBabyInfoId(Integer babyInfoId) {
        this.babyInfoId = babyInfoId;
    }

    public String getBabyImgContent() {
        return babyImgContent;
    }

    public void setBabyImgContent(String babyImgContent) {
        this.babyImgContent = babyImgContent == null ? null : babyImgContent.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}