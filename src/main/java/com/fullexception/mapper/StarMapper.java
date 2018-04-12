package com.fullexception.mapper;

import com.fullexception.entity.Star;
import com.fullexception.entity.StarWithBLOBs;

public interface StarMapper {
    int deleteByPrimaryKey(Integer starId);

    int insert(StarWithBLOBs record);

    int insertSelective(StarWithBLOBs record);

    StarWithBLOBs selectByPrimaryKey(Integer starId);

    int updateByPrimaryKeySelective(StarWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StarWithBLOBs record);

    int updateByPrimaryKey(Star record);
}