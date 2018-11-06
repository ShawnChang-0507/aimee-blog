package com.fullexception.mapper;

import com.fullexception.entity.ReadLog;

public interface ReadLogMapper {
    int deleteByPrimaryKey(Integer readLogId);

    int insert(ReadLog record);

    int insertSelective(ReadLog record);

    ReadLog selectByPrimaryKey(Integer readLogId);

    int updateByPrimaryKeySelective(ReadLog record);

    int updateByPrimaryKey(ReadLog record);
}