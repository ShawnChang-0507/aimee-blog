package com.fullexception.entity;

import java.util.Date;

public class PhotoAlbumDiscuss {
    private Integer photoAlbumDisicussId;

    private Integer photoAlbumId;

    private Integer discussantId;

    private String photoAlbumDiscussContent;

    private Date createDate;

    private String ip;

    public Integer getPhotoAlbumDisicussId() {
        return photoAlbumDisicussId;
    }

    public void setPhotoAlbumDisicussId(Integer photoAlbumDisicussId) {
        this.photoAlbumDisicussId = photoAlbumDisicussId;
    }

    public Integer getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Integer photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public Integer getDiscussantId() {
        return discussantId;
    }

    public void setDiscussantId(Integer discussantId) {
        this.discussantId = discussantId;
    }

    public String getPhotoAlbumDiscussContent() {
        return photoAlbumDiscussContent;
    }

    public void setPhotoAlbumDiscussContent(String photoAlbumDiscussContent) {
        this.photoAlbumDiscussContent = photoAlbumDiscussContent == null ? null : photoAlbumDiscussContent.trim();
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