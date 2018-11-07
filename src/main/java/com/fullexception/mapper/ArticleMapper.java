package com.fullexception.mapper;

import java.util.List;
import java.util.Map;

import com.fullexception.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 得到文章列表 有分页
     * @param map
     * @return
     */
	List<Article> getArticleByAuthorIdAndPage(Map<String, Integer> map);
}