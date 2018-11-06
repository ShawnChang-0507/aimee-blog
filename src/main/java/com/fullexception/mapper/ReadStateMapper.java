package com.fullexception.mapper;

import com.fullexception.entity.ReadState;

public interface ReadStateMapper {
    int deleteByPrimaryKey(Integer readStateId);

    int insert(ReadState record);

    int insertSelective(ReadState record);

    ReadState selectByPrimaryKey(Integer readStateId);

    int updateByPrimaryKeySelective(ReadState record);

    int updateByPrimaryKey(ReadState record);
}