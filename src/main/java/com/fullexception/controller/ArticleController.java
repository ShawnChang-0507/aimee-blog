package com.fullexception.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fullexception.entity.Article;
import com.fullexception.entity.ArticleGroup;
import com.fullexception.entity.Visitor;
import com.fullexception.service.ArticleService;
import com.fullexception.service.VisitorService;

import util.AimeeHelper;

@RequestMapping({ "/article", "/blog" })
@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private VisitorService visitorService;

	@GetMapping("/showArticle")
	public String showArticle(HttpServletRequest request, ModelMap model) {
		int arId = Integer.parseInt(request.getParameter("arId"));
		HttpSession session = request.getSession();
		int visitorId = 0;
		if (session != null) {
			visitorId = session.getAttribute("loginId") == null ? 0 : (int) session.getAttribute("loginId");
		}
		Article article = articleService.getArticleById(arId, visitorId);
		Visitor visitor = visitorService.getVisitorById(article.getAuthorId());
		model.addAttribute("article", article);
		model.addAttribute("author", visitor);
		return "/blog/posts/index";
	}

	@GetMapping("/editBlog")
	public String editBlog(HttpServletRequest request, ModelMap model) {
		Map<String, Object> map = AimeeHelper.loginSystem(request, model, visitorService);
		if ((Boolean) map.get("loginOrNot")){
			int visitorId = ((Visitor)request.getSession().getAttribute("myVisitor")).getVisitorId();
			List<ArticleGroup> groups = articleService.getAllArticleGroupByVisitorId(visitorId);
			model.addAttribute("groups", groups);
			return "/blog/editBlog/index";
		}
		else
			return "/index";
	}
	
	@ResponseBody
	@PostMapping("/addArticleGroup")
	public Map<String, String> addArticleGroup(String groupName, HttpServletRequest request, ModelMap model){
		Map<String, String> map = new HashMap<String, String>();
		
		return map;
	}
}
