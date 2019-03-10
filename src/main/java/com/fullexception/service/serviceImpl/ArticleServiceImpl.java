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
	public int getArticleCountByAuthorId(Integer visitorId) {
		int articleCount = articleMapper.getArticleCountByAuthorid(visitorId);
		return articleCount;
	}

	@Override
	public List<Article> getArticleById(int articleId, int visitorId) {
		List<Article> article = articleMapper.selectByPrimaryKey(articleId);
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

	@Override
	public Map<String, Object> addArticleGroupAndReturn(String groupName, int visitorId) {
		try {
			ArticleGroup ag = new ArticleGroup();
			ag.setVisitorId(visitorId);
			ag.setName(groupName);
			ag.setCreateDate(new Date());
			int insertResult = articleGroupMapper.insertSelective(ag);
			Map<String, Object> map = new HashMap<String, Object>();
			if (insertResult == 0) {
				map.put("res", "false");
				map.put("mes", "该分组已经存在啦！");
			} else {
				List<ArticleGroup> list = articleGroupMapper.getAllArticleGroupByVisitorId(visitorId);
				map.put("res", "false");
				map.put("mes", "成功啦！");
				map.put("functionName", "updateGroupMenu");
				map.put("functionValue", list);
			}
			return map;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int writeArticle(Article article) {
		try{
			return articleMapper.insertSelective(article);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public List<ReadLog> getReadLogByArticleId(int arId) {
		try{
			List<ReadLog> readLogs = readLogMapper.getByArticleId(arId);
			return readLogs;
		}catch(Exception e){
			throw e;
		}
	}

}
