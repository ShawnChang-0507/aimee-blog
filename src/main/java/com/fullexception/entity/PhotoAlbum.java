package com.fullexception.entity;

import java.util.Date;

public class PhotoAlbum {
    private Integer photoAlbumId;

    private Integer ownerId;

    private Integer photoId;

    private String photoAlbumAbstract;

    private String photoAlbumName;

    private Date createDate;

    public Integer getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Integer photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoAlbumAbstract() {
        return photoAlbumAbstract;
    }

    public void setPhotoAlbumAbstract(String photoAlbumAbstract) {
        this.photoAlbumAbstract = photoAlbumAbstract == null ? null : photoAlbumAbstract.trim();
    }

    public String getPhotoAlbumName() {
        return photoAlbumName;
    }

    public void setPhotoAlbumName(String photoAlbumName) {
        this.photoAlbumName = photoAlbumName == null ? null : photoAlbumName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}