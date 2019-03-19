package com.fullexception.mapper;

import com.fullexception.entity.PhotoDiscuss;

public interface PhotoDiscussMapper {
    int deleteByPrimaryKey(Integer photoDisicussId);

    int insert(PhotoDiscuss record);

    int insertSelective(PhotoDiscuss record);

    PhotoDiscuss selectByPrimaryKey(Integer photoDisicussId);

    int updateByPrimaryKeySelective(PhotoDiscuss record);

    int updateByPrimaryKey(PhotoDiscuss record);
}