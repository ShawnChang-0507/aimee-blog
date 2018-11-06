package com.fullexception.mapper;

import com.fullexception.entity.ArticleState;

public interface ArticleStateMapper {
    int deleteByPrimaryKey(Integer articleStateId);

    int insert(ArticleState record);

    int insertSelective(ArticleState record);

    ArticleState selectByPrimaryKey(Integer articleStateId);

    int updateByPrimaryKeySelective(ArticleState record);

    int updateByPrimaryKey(ArticleState record);
}