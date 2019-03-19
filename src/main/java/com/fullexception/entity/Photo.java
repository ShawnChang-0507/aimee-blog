package com.fullexception.entity;

import java.util.Date;

public class Photo {
    private Integer photoId;

    private Integer photoAlbumId;

    private String photoName;

    private String photoAbstract;

    private String photoUrl;

    private Date createDate;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Integer photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoAbstract() {
        return photoAbstract;
    }

    public void setPhotoAbstract(String photoAbstract) {
        this.photoAbstract = photoAbstract == null ? null : photoAbstract.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}