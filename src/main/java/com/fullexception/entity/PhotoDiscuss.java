package com.fullexception.entity;

import java.util.Date;

public class PhotoDiscuss {
    private Integer photoDisicussId;

    private Integer photoId;

    private Integer discussantId;

    private String photoDiscussContent;

    private Date createDate;

    private String ip;

    public Integer getPhotoDisicussId() {
        return photoDisicussId;
    }

    public void setPhotoDisicussId(Integer photoDisicussId) {
        this.photoDisicussId = photoDisicussId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getDiscussantId() {
        return discussantId;
    }

    public void setDiscussantId(Integer discussantId) {
        this.discussantId = discussantId;
    }

    public String getPhotoDiscussContent() {
        return photoDiscussContent;
    }

    public void setPhotoDiscussContent(String photoDiscussContent) {
        this.photoDiscussContent = photoDiscussContent == null ? null : photoDiscussContent.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}