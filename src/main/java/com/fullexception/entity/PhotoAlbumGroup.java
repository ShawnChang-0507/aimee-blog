package com.fullexception.entity;

public class PhotoAlbumGroup {
    private Integer photoAlbumGroupId;

    private String photoAlbumGroupName;

    public Integer getPhotoAlbumGroupId() {
        return photoAlbumGroupId;
    }

    public void setPhotoAlbumGroupId(Integer photoAlbumGroupId) {
        this.photoAlbumGroupId = photoAlbumGroupId;
    }

    public String getPhotoAlbumGroupName() {
        return photoAlbumGroupName;
    }

    public void setPhotoAlbumGroupName(String photoAlbumGroupName) {
        this.photoAlbumGroupName = photoAlbumGroupName == null ? null : photoAlbumGroupName.trim();
    }
}