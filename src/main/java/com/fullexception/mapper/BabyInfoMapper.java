package com.fullexception.mapper;

import com.fullexception.entity.BabyInfo;

public interface BabyInfoMapper {
    int deleteByPrimaryKey(Integer babyInfoId);

    int insert(BabyInfo record);

    int insertSelective(BabyInfo record);

    BabyInfo selectByPrimaryKey(Integer babyInfoId);

    int updateByPrimaryKeySelective(BabyInfo record);

    int updateByPrimaryKeyWithBLOBs(BabyInfo record);

    int updateByPrimaryKey(BabyInfo record);
}