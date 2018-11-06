package com.fullexception.mapper;

import com.fullexception.entity.LevelGroup;

public interface LevelGroupMapper {
    int deleteByPrimaryKey(Integer levelGroupId);

    int insert(LevelGroup record);

    int insertSelective(LevelGroup record);

    LevelGroup selectByPrimaryKey(Integer levelGroupId);

    int updateByPrimaryKeySelective(LevelGroup record);

    int updateByPrimaryKey(LevelGroup record);
}