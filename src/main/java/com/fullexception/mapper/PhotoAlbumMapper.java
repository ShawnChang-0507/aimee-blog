package com.fullexception.mapper;

import com.fullexception.entity.PhotoAlbum;

public interface PhotoAlbumMapper {
    int deleteByPrimaryKey(Integer photoAlbumId);

    int insert(PhotoAlbum record);

    int insertSelective(PhotoAlbum record);

    PhotoAlbum selectByPrimaryKey(Integer photoAlbumId);

    int updateByPrimaryKeySelective(PhotoAlbum record);

    int updateByPrimaryKey(PhotoAlbum record);
}