package com.fullexception.mapper;

import com.fullexception.entity.ArticleAssist;

public interface ArticleAssistMapper {
    int deleteByPrimaryKey(Integer articleAssist);

    int insert(ArticleAssist record);

    int insertSelective(ArticleAssist record);

    ArticleAssist selectByPrimaryKey(Integer articleAssist);

    int updateByPrimaryKeySelective(ArticleAssist record);

    int updateByPrimaryKey(ArticleAssist record);
}