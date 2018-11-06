package com.fullexception.mapper;

import com.fullexception.entity.ArticlePublic;

public interface ArticlePublicMapper {
    int deleteByPrimaryKey(Integer articlePublicId);

    int insert(ArticlePublic record);

    int insertSelective(ArticlePublic record);

    ArticlePublic selectByPrimaryKey(Integer articlePublicId);

    int updateByPrimaryKeySelective(ArticlePublic record);

    int updateByPrimaryKey(ArticlePublic record);
}