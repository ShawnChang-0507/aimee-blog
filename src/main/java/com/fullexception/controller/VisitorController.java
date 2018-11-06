package com.fullexception.controller;

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

import com.fullexception.entity.Visitor;
import com.fullexception.service.VisitorService;

@Controller
@RequestMapping("/visitor")
public class VisitorController extends AuthorizingRealm{
	@Autowired
	private VisitorService visitorService;

	@GetMapping(value = "")
	public String touristVisitor(ModelMap model){
		Visitor touristVisitor = visitorService.tourist();
		model.addAttribute("tourist", touristVisitor);
		return "/index";
	}
	
	@GetMapping(value = "/index")
	public String showIndex(HttpSession session) {
		/*Visitor visitor = visitorService.login("aimeeblog", "ranmeng1");
		if (visitor != null)
			session.setAttribute("visitor", visitor);*/
		return "index";
	}

	@GetMapping(value = "/blog")
	public String showBlog(ModelMap model) {
		return "blog/index";
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
