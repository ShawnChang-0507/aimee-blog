package com.fullexception.mapper;

import com.fullexception.entity.ArticleImg;

public interface ArticleImgMapper {
    int deleteByPrimaryKey(Integer articleImgId);

    int insert(ArticleImg record);

    int insertSelective(ArticleImg record);

    ArticleImg selectByPrimaryKey(Integer articleImgId);

    int updateByPrimaryKeySelective(ArticleImg record);

    int updateByPrimaryKey(ArticleImg record);
}