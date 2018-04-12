package com.fullexception.mapper;

import com.fullexception.entity.ArticleGroup;

public interface ArticleGroupMapper {
    int deleteByPrimaryKey(Integer articleGroupId);

    int insert(ArticleGroup record);

    int insertSelective(ArticleGroup record);

    ArticleGroup selectByPrimaryKey(Integer articleGroupId);

    int updateByPrimaryKeySelective(ArticleGroup record);

    int updateByPrimaryKey(ArticleGroup record);
}