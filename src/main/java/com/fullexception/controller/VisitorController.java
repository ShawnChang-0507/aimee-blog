package com.fullexception.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
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
public class VisitorController extends AuthorizingRealm {
	@Autowired
	private VisitorService visitorService;

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LoginInfoService loginInfoService;
	
	/**
	 * 登录信息
	 */
	private Map<String, Integer> loginInfo = new HashMap<String, Integer>();

	/**
	 * 默认访问博客
	 */
	private Visitor visitor;
	
	/**
	 * 维护登陆信息
	 * @param ip
	 */
	private void putLoginInfo(String ip){
		if (loginInfo.containsKey(ip)){
			loginInfo.put(ip, loginInfo.get(ip) + 1);
		}else{
			loginInfo.put(ip, 1);
		}
	}

	@GetMapping("/")
	public String touristVisitor(HttpServletRequest request, ModelMap model) {
		String ip = AimeeHelper.getIpAddr(request);
		visitor = visitorService.tourist(ip);
		putLoginInfo(ip);
		model.addAttribute("tourist", visitor);
		return "/index";
	}

	@GetMapping("/blog")
	public String showBlog(HttpServletRequest request, ModelMap model) {
		if (visitor == null) {
			String ip = AimeeHelper.getIpAddr(request);
			visitor = visitorService.tourist(ip);
		}
		List<Article> articles = articleService.showArticleByAuthorId(visitor.getVisitorId(), 0);
		Map<String, Integer> map = loginInfoService.countTheNumberOfVisitors();
		
		model.addAttribute("tourist", visitor);
		model.addAttribute("articles", articles);
		int totalVisitorNumber = map.get("totalVisitorNumber");
		int totalVisitNumber = map.get("totalVisitNumber");
		model.addAttribute("totalVisitorNumber", totalVisitorNumber);
		model.addAttribute("totalVisitNumber", totalVisitNumber);
		
		return "/blog/index";
	}
	
	@ResponseBody
	@PostMapping("/checkLoginName")
	public Map<String, String> checkLoginName(String loginName){
		Map<String, String> map = visitorService.checkLoginName(loginName);
		return map;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (username == null){
			throw new AccountException("Null usernames are not allowed by this realm.");
		}
		else{
			
		}
		return null;
	}
}
