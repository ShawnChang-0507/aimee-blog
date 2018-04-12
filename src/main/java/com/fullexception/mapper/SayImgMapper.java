package com.fullexception.mapper;

import com.fullexception.entity.SayImg;

public interface SayImgMapper {
    int deleteByPrimaryKey(Integer sayImgId);

    int insert(SayImg record);

    int insertSelective(SayImg record);

    SayImg selectByPrimaryKey(Integer sayImgId);

    int updateByPrimaryKeySelective(SayImg record);

    int updateByPrimaryKey(SayImg record);
}