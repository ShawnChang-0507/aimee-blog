package com.fullexception.mapper;

import java.util.List;

import com.fullexception.entity.ArticleGroup;

public interface ArticleGroupMapper {
    int deleteByPrimaryKey(Integer articleGroupId);

    int insert(ArticleGroup record);

    int insertSelective(ArticleGroup record);

    ArticleGroup selectByPrimaryKey(Integer articleGroupId);

    int updateByPrimaryKeySelective(ArticleGroup record);

    int updateByPrimaryKey(ArticleGroup record);

    /**
     * 通过作者得到所有文章分组
     * @param visitorId
     * @return
     */
	List<ArticleGroup> getAllArticleGroupByVisitorId(int visitorId);
}