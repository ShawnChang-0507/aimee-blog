package com.fullexception.mapper;

import com.fullexception.entity.PhotoAlbumReadLog;

public interface PhotoAlbumReadLogMapper {
    int deleteByPrimaryKey(Integer photoAlbumReadLogId);

    int insert(PhotoAlbumReadLog record);

    int insertSelective(PhotoAlbumReadLog record);

    PhotoAlbumReadLog selectByPrimaryKey(Integer photoAlbumReadLogId);

    int updateByPrimaryKeySelective(PhotoAlbumReadLog record);

    int updateByPrimaryKey(PhotoAlbumReadLog record);
}