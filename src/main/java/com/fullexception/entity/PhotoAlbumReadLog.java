package com.fullexception.entity;

import java.util.Date;

public class PhotoAlbumReadLog {
    private Integer photoAlbumReadLogId;

    private Integer readerId;

    private Integer photoAlbumId;

    private Date createDate;

    private String ip;

    public Integer getPhotoAlbumReadLogId() {
        return photoAlbumReadLogId;
    }

    public void setPhotoAlbumReadLogId(Integer photoAlbumReadLogId) {
        this.photoAlbumReadLogId = photoAlbumReadLogId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Integer photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
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