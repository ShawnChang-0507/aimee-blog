package com.fullexception.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.Article;
import com.fullexception.mapper.ArticleMapper;
import com.fullexception.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> showArticleByAuthorId(int authorId, int currentPage) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("authorId", authorId);
		map.put("currentPage", currentPage);
		List<Article> list = articleMapper.getArticleByAuthorIdAndPage(map);
		return list;
	}

}
