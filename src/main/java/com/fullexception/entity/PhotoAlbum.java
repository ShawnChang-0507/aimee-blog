package com.fullexception.entity;

public class PhotoAlbum {
    private Integer photoAlbumId;

    private Integer imgMenuId;

    private String photoContent;

    private String photoRemark;

    public Integer getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Integer photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public Integer getImgMenuId() {
        return imgMenuId;
    }

    public void setImgMenuId(Integer imgMenuId) {
        this.imgMenuId = imgMenuId;
    }

    public String getPhotoContent() {
        return photoContent;
    }

    public void setPhotoContent(String photoContent) {
        this.photoContent = photoContent == null ? null : photoContent.trim();
    }

    public String getPhotoRemark() {
        return photoRemark;
    }

    public void setPhotoRemark(String photoRemark) {
        this.photoRemark = photoRemark == null ? null : photoRemark.trim();
    }
}