package com.fullexception.service.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.Article;
import com.fullexception.entity.ArticleGroup;
import com.fullexception.entity.ReadLog;
import com.fullexception.mapper.ArticleGroupMapper;
import com.fullexception.mapper.ArticleMapper;
import com.fullexception.mapper.ReadLogMapper;
import com.fullexception.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private ReadLogMapper readLogMapper;
	
	@Autowired
	private ArticleGroupMapper articleGroupMapper;

	@Override
	public List<Article> showArticleByAuthorId(int authorId, int currentPage) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("authorId", authorId);
		map.put("currentPage", currentPage);
		List<Article> list = articleMapper.getArticleByAuthorIdAndPage(map);
		return list;
	}

	@Override
	public Article getArticleById(int articleId, int visitorId) {
		Article article = articleMapper.selectByPrimaryKey(articleId);
		writeReadLog(articleId, visitorId);
		return article;
	}

	@Override
	public int writeReadLog(int articleId, int visitorId) {
		ReadLog rl = new ReadLog();
		rl.setArticleId(articleId);
		rl.setCreateDate(new Date());
		if (visitorId > 0) {
			rl.setVisitorId(visitorId);
		}
		int result = readLogMapper.insertSelective(rl);
		return result;
	}

	@Override
	public List<ArticleGroup> getAllArticleGroupByVisitorId(int visitorId) {
		List<ArticleGroup> groups = articleGroupMapper.getAllArticleGroupByVisitorId(visitorId);
		return groups;
	}

}
