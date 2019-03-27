package com.fullexception;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fullexception.entity.Visitor;
import com.fullexception.service.VisitorService;
import com.google.gson.Gson;

import util.AimeeHelper;

//申请切面
@Aspect
// 生命spring组件
@Component
// 设置优先级，数值越小，优先级越高
@Order(1)
public class LogAspect {

	private Logger log = Logger.getLogger(getClass());
	private Gson gson = new Gson();
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	@Autowired
	private VisitorService visitorService;

	@Pointcut("execution(public * com.fullexception.controller.*.*(..))")
	private void controllerAspect() {
	}

	@Pointcut("execution(public * com.fullexception.mapper.*.*(..))")
	private void mapperAspect(){}
	
	// 请求method前打印内容
	@Before(value = "controllerAspect()")
	public void controllerBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		Map<String, Object> map = AimeeHelper.loginSystem(request, null, visitorService);
		AimeeHelper.visitor.set((Visitor) map.get("visitor"));
		// 判断 登录是否记录 登录次数，如果false，那么手动添加登录次数
		if (!(Boolean) map.get("loginInfoOrNot")) {
			AimeeHelper.appendLoginInfo(AimeeHelper.getIpAddr(request), AimeeHelper.visitor.get(), visitorService);
		}
		// 打印请求内容
		log.info("");
		log.info("");
		log.info("");
		log.info("");
		log.info("……………………………………请求内容…………………………………………");
		log.info("请求地址:" + request.getRequestURL().toString());
		log.info("来访地址:" + AimeeHelper.getIpAddr(request));
		log.info("请求时间:" + AimeeHelper.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		log.info("请求方式:" + request.getMethod());
		log.info("请求类方法:" + joinPoint.getSignature());
		log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
		log.info("……………………………………请求内容……………………………………………");
	}
	// 在方法执行完结后打印返回内容
	@AfterReturning(returning = "o", pointcut = "controllerAspect()")
	public void controllerAfterReturing(Object o) {
		log.info("______________返回内容________________");
		log.info("响应时间:" + (System.currentTimeMillis() - startTime.get()));
		log.info("Response内容:" + gson.toJson(o));
		log.info("______________返回内容________________");
	}
	
	@AfterThrowing(pointcut="mapperAspect()", throwing="exception")
	public void mapperThrowing(JoinPoint joinPoint, Throwable exception){
		log.info("&&&&&&&&&&&&&&&异常信息&&&&&&&&&&&&&&&");
		log.info("异常时间:" + AimeeHelper.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		log.info("异常类方法:" + joinPoint.getSignature());
		log.info("异常类方法参数:" + Arrays.toString(joinPoint.getArgs()));
		log.info("异常信息:" + exception);
		log.info("&&&&&&&&&&&&&&&异常信息&&&&&&&&&&&&&&&");
	}
}
