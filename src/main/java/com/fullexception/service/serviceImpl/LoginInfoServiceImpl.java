package com.fullexception.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.mapper.LoginInfoMapper;
import com.fullexception.service.LoginInfoService;

@Service("loginInfoService")
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	private LoginInfoMapper loginInfoMapper;

	@Override
	public Map<String, Integer> countTheNumberOfVisitors() {
		int todayVisitorNumber = loginInfoMapper.countTheNumberOfVisitorsToday();
		int totalVisitorNumber = loginInfoMapper.countTheTotalNumberOfVisitors();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("totayVisitorNumber", todayVisitorNumber);
		map.put("totalVisitorNumber", totalVisitorNumber);
		return map;
	}

}
