package com.fullexception.mapper;

import com.fullexception.entity.BlogLevel;

public interface BlogLevelMapper {
    int deleteByPrimaryKey(Integer blogLevelId);

    int insert(BlogLevel record);

    int insertSelective(BlogLevel record);

    BlogLevel selectByPrimaryKey(Integer blogLevelId);

    int updateByPrimaryKeySelective(BlogLevel record);

    int updateByPrimaryKey(BlogLevel record);
}