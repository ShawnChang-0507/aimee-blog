package com.fullexception.service;

import java.util.List;
import java.util.Map;

import com.fullexception.entity.Article;
import com.fullexception.entity.ArticleGroup;
import com.fullexception.entity.ReadLog;

public interface ArticleService {

	/**
	 * 通过作者得到当前作者所有文章
	 * 
	 * @param authorId
	 * @param currentPage
	 *            当前页，分页用
	 * @return
	 */
	public List<Article> showArticleByAuthorId(int authorId, int currentPage);
	
	/**
	 * 根据id获取文章
	 * @param articleId
	 * @return
	 */
	public Article getArticleById(int articleId, int visitorId);
	
	/**
	 * 添加文章阅读记录
	 * @param articleId
	 * @return
	 */
	public int writeReadLog(int articleId, int visitorId);

	/**
	 * 根据id得到visitor的所有articleGroup
	 * @param visitorId
	 * @return
	 */
	public List<ArticleGroup> getAllArticleGroupByVisitorId(int visitorId);

	/**
	 * 添加文章分组并返回新list
	 * @param groupName
	 * @param visitorId
	 * @return
	 */
	public Map<String, Object> addArticleGroupAndReturn(String groupName, int visitorId);

	/**
	 * 插入文章
	 * @param article
	 * @return
	 */
	public int writeArticle(Article article);

	/**
	 * 得到文章的阅读信息
	 * @param arId
	 * @return
	 */
	public List<ReadLog> getReadLogByArticleId(int arId);
}
