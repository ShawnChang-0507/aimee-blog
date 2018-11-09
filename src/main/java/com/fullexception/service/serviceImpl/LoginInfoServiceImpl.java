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
		int totalVisitorNumber = loginInfoMapper.countTheNumberOfVisitors();
		int totalVisitNumber = loginInfoMapper.countTheNumberOfVisits();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("totalVisitorNumber", totalVisitorNumber);
		map.put("totalVisitNumber", totalVisitNumber);
		return map;
	}

}
