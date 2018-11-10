package com.fullexception.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullexception.entity.Article;
import com.fullexception.entity.Visitor;
import com.fullexception.service.ArticleService;
import com.fullexception.service.VisitorService;

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
	public String editBlog(HttpServletRequest request, ModelMap model){
		/*HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			if ("loginName".equals(cookie.getName())){
				
			}else if("loginPassword".equals(cookie.getName())){
				
			}
		}*/
		return "/blog/editBlog/index";
	}
}
