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
import com.fullexception.entity.Discuss;
import com.fullexception.entity.ReadLog;
import com.fullexception.entity.Visitor;
import com.fullexception.service.ArticleService;
import com.fullexception.service.DiscussService;
import com.fullexception.service.LoginInfoService;
import com.fullexception.service.VisitorService;

import util.AimeeHelper;

@RequestMapping({ "/article", "/blog" })
@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private DiscussService discussService;

	@Autowired
	private LoginInfoService loginInfoService;

	@ResponseBody
	@PostMapping("/pullPage")
	public Map<String, Object> selectPage(Integer currentPage, HttpServletRequest request) {
		/*if (AimeeHelper.visitor == null) {
			AimeeHelper.visitor.set(visitorService.tourist());
		}*/
		int articleCount = articleService.getArticleCountByAuthorId(AimeeHelper.visitor.get().getVisitorId());
		Map<String, Object> map = new HashMap<String, Object>();
		if (articleCount / 5 > currentPage) {
			currentPage++;
			List<Article> articles = articleService.showArticleByAuthorId(AimeeHelper.visitor.get().getVisitorId(), currentPage * 5);
			map.put("articles", articles);
			map.put("res", true);
		}else {
			map.put("res", false);
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping("/discuss")
	public Map<String, String> discuss(String content, int articleId, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Visitor visitor = AimeeHelper.checkLogin(request);
			Discuss discuss = new Discuss();
			if (visitor != null) {
				discuss.setVisitorId(visitor.getVisitorId());
			}
			discuss.setIp(AimeeHelper.getIpAddr(request));
			discuss.setArticleId(articleId);
			discuss.setDiscussCreateDate(new Date());
			discuss.setReadStateId(1);
			discuss.setContent(content);
			discussService.insertDiscuss(discuss);
			map.put("res", "您的留言已黏贴到萌村期刊底部~谢谢参与(￣▽￣)");
			return map;
		}catch(Exception e) {
			map.put("res", "村里快递员把您的留言弄丢了。。。");
			return map;
		}
	}
	
	@GetMapping("/showBlog")
	public String showBlogs(int pageNum, HttpServletRequest request, ModelMap model){
		if (pageNum < 1)
			pageNum = 1;
		List<Article> articles = articleService.showArticleByAuthorId(AimeeHelper.visitor.get().getVisitorId(), pageNum);
		int articleCount = articleService.getArticleCountByAuthorId(AimeeHelper.visitor.get().getVisitorId());
		AimeeHelper.visitNumber = loginInfoService.countTheNumberOfVisitors();
		model.addAttribute("tourist", AimeeHelper.visitor.get());
		model.addAttribute("articles", articles);
		int totalVisitorNumber = AimeeHelper.visitNumber.get("totalVisitorNumber");
		int totalVisitNumber = AimeeHelper.visitNumber.get("totalVisitNumber");
		model.addAttribute("totalVisitorNumber", totalVisitorNumber);
		model.addAttribute("totalVisitNumber", totalVisitNumber);
		model.addAttribute("articleCount", articleCount);
		model.addAttribute("currentPage", pageNum);
		return "/blog/index";
	}
	
	@GetMapping("/showArticle")
	public String showArticle(HttpServletRequest request, ModelMap model) {
		int arId = Integer.parseInt(request.getParameter("arId"));
		HttpSession session = request.getSession();
		int visitorId = 0;
		String readerIp = AimeeHelper.getIpAddr(request);
		if (session != null) {
			visitorId = session.getAttribute("loginId") == null ? 0 : (int) session.getAttribute("loginId");
		}
		List<Article> articles = articleService.getArticleById(arId, visitorId, readerIp);
		Article last = new Article();
		Article next = new Article();
		Article article = new Article();
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == arId) {
				article = articles.get(i);
				if (i - 1 >= 0) {
					last = articles.get(i - 1);
				} else {
					last = null;
				}
				if (i + 1 < articles.size()) {
					next = articles.get(i + 1);
				} else {
					next = null;
				}
			}
		}
		Visitor visitor = visitorService.getVisitorById(article.getAuthorId());
		List<ReadLog> readInfos = articleService.getReadLogByArticleId(arId);
		int readCount = readInfos.size();
		int totalVisitorNumber = AimeeHelper.visitNumber.get("totalVisitorNumber");
		int totalVisitNumber = AimeeHelper.visitNumber.get("totalVisitNumber");
		model.addAttribute("totalVisitorNumber", totalVisitorNumber);
		model.addAttribute("totalVisitNumber", totalVisitNumber);
		model.addAttribute("readCount", readCount);
		model.addAttribute("article", article);
		model.addAttribute("author", visitor);
		model.addAttribute("next", next);
		model.addAttribute("last", last);
		return "/blog/posts/index";
	}

	@GetMapping("/editBlog")
	public String editBlog(HttpServletRequest request, ModelMap model) {
		Map<String, Object> map = AimeeHelper.loginSystem(request, model, visitorService);
		if ((Boolean) map.get("loginOrNot")) {
			int visitorId = ((Visitor) request.getSession().getAttribute("myVisitor")).getVisitorId();
			List<ArticleGroup> groups = articleService.getAllArticleGroupByVisitorId(visitorId);
			model.addAttribute("groups", groups);
			return "/blog/editBlog/index";
		} else
			return "/index";
	}

	@ResponseBody
	@PostMapping("/addArticleGroup")
	public Map<String, Object> addArticleGroup(String groupName, HttpServletRequest request) {
		Map<String, Object> map = AimeeHelper.loginSystem(request, null, visitorService);
		if ((Boolean) map.get("loginOrNot")) {
			int visitorId = ((Visitor) request.getSession().getAttribute("myVisitor")).getVisitorId();
			map = articleService.addArticleGroupAndReturn(groupName, visitorId);
		}
		return map;
	}

	@ResponseBody
	@PostMapping("/writeBlog")
	public Map<String, Object> writeBlog(int groupId, String title, String secondTitle, String articleContent,
			HttpServletRequest request, ModelMap model) {
		Map<String, Object> map = AimeeHelper.loginSystem(request, null, visitorService);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!(Boolean) map.get("loginOrNot")) {
			resultMap.put("mes", "尊敬的贵宾，请先进行进村登记，然后才能写文章哦~");
			resultMap.put("res", "false");
			return resultMap;
		}
		int chineseSize = AimeeHelper.getChineseSize(articleContent);
		int readMinutes = chineseSize / 400 + 1;
		Article a = new Article();
		a.setArticleStateId(1);
		a.setArticlePublicId(1);
		a.setArticleGroupId(groupId);
		a.setAuthorId(((Visitor) map.get("visitor")).getVisitorId());
		a.setArticleTitle(title);
		a.setSecondTitle(secondTitle);
		a.setArticleContent(articleContent);
		a.setSpendTime(readMinutes);
		a.setCreateDate(new Date());

		int result = articleService.writeArticle(a);
		if (result == 0) {
			resultMap.put("mes", "萌妹在护送文章到萌村儿出版社的路上把文章弄丢了o(╥﹏╥)o");
			resultMap.put("res", "false");
		} else {
			resultMap.put("mes", "尊敬的贵宾~您的文章写得极好~出版社已经出版，已经可以在博客上浏览啦(*^▽^*");
			resultMap.put("functionName", "toBlogPage");
			resultMap.put("functionValue", "what a fuck");
		}

		return resultMap;
	}
	
	@GetMapping("/photoAlbum")
	public String photoAlbum(HttpServletRequest request, ModelMap model){
		return "/blog/photoAlbum";
	}
	
	@GetMapping("/categories")
	public String categories(HttpServletRequest request, ModelMap model){
		int visitorId = AimeeHelper.visitor.get().getVisitorId();
		List<ArticleGroup> articleGroups = articleService.getAllArticleGroupByVisitorId(visitorId);
		model.addAttribute("articleGroups", articleGroups);
		model.addAttribute("tourist", AimeeHelper.visitor.get());
		return "/blog/categories/index";
	}
}
