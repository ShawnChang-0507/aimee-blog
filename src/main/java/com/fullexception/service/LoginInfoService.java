package com.fullexception.service;

import java.util.Map;

public interface LoginInfoService {
	/**
	 * 统计网站访问人数
	 * @return map.todayVisitorNumber 当日访问人数
	 * 		   map.totalVisitorNumber 访问总人数
	 */
	public Map<String, Integer> countTheNumberOfVisitors();
}
