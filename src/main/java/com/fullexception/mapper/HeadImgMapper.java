package com.fullexception.mapper;

import com.fullexception.entity.HeadImg;

public interface HeadImgMapper {
    int deleteByPrimaryKey(Integer headImgId);

    int insert(HeadImg record);

    int insertSelective(HeadImg record);

    HeadImg selectByPrimaryKey(Integer headImgId);

    int updateByPrimaryKeySelective(HeadImg record);

    int updateByPrimaryKey(HeadImg record);
}