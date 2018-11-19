package com.fullexception.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionhandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof UnauthenticatedException) {
			attributes.put("code", "1000001");
			attributes.put("msg", "token错误");
		} else if (ex instanceof UnauthorizedException) {
			attributes.put("code", "1000002");
			attributes.put("msg", "用户无权限");
		} else {
			attributes.put("code", "1000003");
			attributes.put("msg", ex.getMessage());
		}
		ModelAndView mv = new ModelAndView("exceptionInfo", attributes);
		return mv;
	}

}
