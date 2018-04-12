package com.fullexception.mapper;

import com.fullexception.entity.PhotoAlbumGroup;

public interface PhotoAlbumGroupMapper {
    int deleteByPrimaryKey(Integer photoAlbumGroupId);

    int insert(PhotoAlbumGroup record);

    int insertSelective(PhotoAlbumGroup record);

    PhotoAlbumGroup selectByPrimaryKey(Integer photoAlbumGroupId);

    int updateByPrimaryKeySelective(PhotoAlbumGroup record);

    int updateByPrimaryKey(PhotoAlbumGroup record);
}