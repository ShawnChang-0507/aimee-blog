package com.fullexception.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullexception.entity.Article;
import com.fullexception.entity.Visitor;
import com.fullexception.service.ArticleService;
import com.fullexception.service.VisitorService;

import util.AimeeHelper;

@Controller
@RequestMapping
public class VisitorController extends AuthorizingRealm{
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private ArticleService articleService;
	
	private Visitor visitor;
	
	@GetMapping(value = "/index")
	public String showIndex(HttpSession session) {
		/*Visitor visitor = visitorService.login("aimeeblog", "ranmeng1");
		if (visitor != null)
			session.setAttribute("visitor", visitor);*/
		return "index";
	}
	
	@GetMapping("/")
	public String touristVisitor(HttpServletRequest request, ModelMap model) {
		String ip = AimeeHelper.getIpAddr(request);
		visitor = visitorService.tourist(ip);
		model.addAttribute("tourist", visitor);
		return "/index";
	}
	
	@GetMapping("/blog")
	public String showBlog(HttpServletRequest request, ModelMap model){
		if (visitor == null){
			String ip = AimeeHelper.getIpAddr(request);
			visitor = visitorService.tourist(ip);
		}
		List<Article> articles = articleService.showArticleByAuthorId(visitor.getVisitorId(), 0);
		model.addAttribute("tourist", visitor);
		model.addAttribute("articles", articles);
		return "/blog/index";
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
}
