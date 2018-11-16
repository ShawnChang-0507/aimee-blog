package com.fullexception.controller;

import java.util.Date;
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
	public Map<String, Object> addArticleGroup(String groupName, HttpServletRequest request){
		Map<String, Object> map = AimeeHelper.loginSystem(request, null, visitorService);
		if ((Boolean) map.get("loginOrNot")){
			int visitorId = ((Visitor)request.getSession().getAttribute("myVisitor")).getVisitorId();
			map = articleService.addArticleGroupAndReturn(groupName, visitorId);
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping("/writeBlog")
	public Map<String, Object> writeBlog(int groupId, String title, String secondTitle, String articleContent, HttpServletRequest request, ModelMap model){
		Map<String, Object> map = AimeeHelper.loginSystem(request, null, visitorService);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!(Boolean)map.get("loginOrNot")){
			resultMap.put("mes", "尊敬的贵宾，请先进行进村登记，然后才能写文章哦~");
			resultMap.put("res", "false");
			return resultMap;
		}
		int chineseSize = AimeeHelper.getChineseSize(articleContent);
		int readMinutes = chineseSize / 400 + 1;
		Article a = new Article();
		a.setArticleGroupId(groupId);
		a.setAuthorId(((Visitor)map.get("visitor")).getVisitorId());
		a.setArticleTitle(title);
		a.setSecondTitle(secondTitle);
		a.setArticleContent(articleContent);
		a.setSpendTime(readMinutes);
		a.setCreateDate(new Date());
		
		int result = articleService.writeArticle(a);
		if (result == 0){
			resultMap.put("mes", "萌妹在护送文章到萌村儿出版社的路上把文章弄丢了o(╥﹏╥)o");
			resultMap.put("res", "false");
		}
		else{
			resultMap.put("mes", "尊敬的贵宾~您的文章写得极好~出版社已经出版，已经可以在博客上浏览啦(*^▽^*");
			resultMap.put("functionName", "toBlogPage");
			resultMap.put("functionValue", "what a fuck");
		}
		
		return resultMap;
	}
}
