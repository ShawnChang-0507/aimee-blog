package com.fullexception.mapper;

import com.fullexception.entity.BabyImg;

public interface BabyImgMapper {
    int deleteByPrimaryKey(Integer babyImgId);

    int insert(BabyImg record);

    int insertSelective(BabyImg record);

    BabyImg selectByPrimaryKey(Integer babyImgId);

    int updateByPrimaryKeySelective(BabyImg record);

    int updateByPrimaryKey(BabyImg record);
}