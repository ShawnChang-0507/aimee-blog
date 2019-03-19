package com.fullexception.mapper;

import com.fullexception.entity.PhotoAlbumDiscuss;

public interface PhotoAlbumDiscussMapper {
    int deleteByPrimaryKey(Integer photoAlbumDisicussId);

    int insert(PhotoAlbumDiscuss record);

    int insertSelective(PhotoAlbumDiscuss record);

    PhotoAlbumDiscuss selectByPrimaryKey(Integer photoAlbumDisicussId);

    int updateByPrimaryKeySelective(PhotoAlbumDiscuss record);

    int updateByPrimaryKey(PhotoAlbumDiscuss record);
}