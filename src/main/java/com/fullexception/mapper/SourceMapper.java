package com.fullexception.mapper;

import com.fullexception.entity.Source;

public interface SourceMapper {
    int deleteByPrimaryKey(Integer sourceId);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(Integer sourceId);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
}