package com.fullexception.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fullexception.entity.Article;
import com.fullexception.entity.Visitor;
import com.fullexception.service.ArticleService;
import com.fullexception.service.LoginInfoService;
import com.fullexception.service.VisitorService;

import util.AimeeHelper;

@Controller
@RequestMapping
public class VisitorController {
	@Autowired
	private VisitorService visitorService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private LoginInfoService loginInfoService;

	/**
	 * 默认访问博客
	 *//*
		 * private Visitor visitor;
		 */

	@GetMapping("/")
	public String touristVisitor(HttpServletRequest request, ModelMap model) {
		// Subject subject = SecurityUtils.getSubject();
		// if (!subject.isAuthenticated()){
		Map<String, Object> map = AimeeHelper.loginSystem(request, model, visitorService);
		AimeeHelper.visitor = (Visitor) map.get("visitor");
		// 判断 登录是否记录 登录次数，如果false，那么手动添加登录次数
		if (!(Boolean) map.get("loginInfoOrNot")) {
			AimeeHelper.appendLoginInfo(AimeeHelper.getIpAddr(request), AimeeHelper.visitor, visitorService);
		}
		// }
		// else{
		// model.addAttribute("tourist", (Visitor)subject.getPrincipal());
		// }
		return "/index";
	}

	@GetMapping("/blog")
	public String showBlog(HttpServletRequest request, ModelMap model) {
		if (AimeeHelper.visitor == null) {
			AimeeHelper.visitor = visitorService.tourist();
		}
		List<Article> articles = articleService.showArticleByAuthorId(AimeeHelper.visitor.getVisitorId(), 0);
		int articleCount = articleService.getArticleCountByAuthorId(AimeeHelper.visitor.getVisitorId());
		AimeeHelper.visitNumber = loginInfoService.countTheNumberOfVisitors();

		model.addAttribute("tourist", AimeeHelper.visitor);
		model.addAttribute("articles", articles);
		int totalVisitorNumber = AimeeHelper.visitNumber.get("totalVisitorNumber");
		int totalVisitNumber = AimeeHelper.visitNumber.get("totalVisitNumber");
		model.addAttribute("totalVisitorNumber", totalVisitorNumber);
		model.addAttribute("totalVisitNumber", totalVisitNumber);
		model.addAttribute("articleCount", articleCount);
		return "/blog/index";
	}

	@PostMapping("/blog")
	public String selectPage(int currentPage, HttpServletRequest request, ModelMap model) {
		if (AimeeHelper.visitor == null) {
			AimeeHelper.visitor = visitorService.tourist();
		}
		List<Article> articles = articleService.showArticleByAuthorId(AimeeHelper.visitor.getVisitorId(), currentPage);
		int articleCount = articleService.getArticleCountByAuthorId(AimeeHelper.visitor.getVisitorId());
		AimeeHelper.visitNumber = loginInfoService.countTheNumberOfVisitors();

		model.addAttribute("tourist", AimeeHelper.visitor);
		model.addAttribute("articles", articles);
		int totalVisitorNumber = AimeeHelper.visitNumber.get("totalVisitorNumber");
		int totalVisitNumber = AimeeHelper.visitNumber.get("totalVisitNumber");
		model.addAttribute("totalVisitorNumber", totalVisitorNumber);
		model.addAttribute("totalVisitNumber", totalVisitNumber);
		model.addAttribute("articleCount", articleCount);
		return "/blog/index";
	}

	@ResponseBody
	@PostMapping("/register")
	public Map<String, String> register(String loginName, String loginPassword, String nickName) {
		loginPassword = AimeeHelper.encryptBasedDes(loginPassword);
		Map<String, String> map = visitorService.register(loginName, loginPassword, nickName);
		return map;
	}

	@ResponseBody
	@PostMapping("/login")
	public Map<String, String> login(String loginName, String loginPassword, HttpServletResponse response,
			HttpServletRequest request) {
		loginPassword = AimeeHelper.encryptBasedDes(loginPassword);
		Visitor myVisitor = visitorService.login(loginName, loginPassword);
		Map<String, String> map = new HashMap<String, String>();
		if (myVisitor != null) {
			HttpSession session = request.getSession();
			response.addCookie(AimeeHelper.putCookie(myVisitor));
			session.setAttribute("myVisitor", myVisitor);
			map.put("mes", String.format("亲爱的超级无敌VIP‘%s’欢迎光临冉萌村!(旁白：这时锣鼓喧天，鞭炮齐鸣！噼里啪啦！整个冉萌村庄都被炮烟儿淹没……)",
					myVisitor.getNickName() == null ? myVisitor.getLoginName() : myVisitor.getNickName()));
			map.put("res", "true");
		} else {
			map.put("mes", "萌妹在村里的VIP名单里翻了八百遍，也没找到您的名字o(╥﹏╥)o");
			map.put("res", "false");
		}
//		UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPassword);
//		Subject subject = SecurityUtils.getSubject();
//		subject.login(token);
		AimeeHelper.visitor = myVisitor;
		return map;
	}

	@ResponseBody
	@PostMapping("/quitLogin")
	public Map<String, String> quitLogin(HttpServletRequest request) {
		AimeeHelper.quitLogin(request);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mes", "尊贵的VIP，您已办好离村儿手续~欢迎下次光临━(*｀∀´*)ノ亻!");
		map.put("res", "true");
		return map;
	}
}
