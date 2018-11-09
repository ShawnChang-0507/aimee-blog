package com.fullexception.service.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.LoginInfo;
import com.fullexception.entity.Visitor;
import com.fullexception.mapper.LoginInfoMapper;
import com.fullexception.mapper.VisitorMapper;
import com.fullexception.service.VisitorService;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	public VisitorMapper visitorMapper;
	
	@Autowired
	public LoginInfoMapper loginInfoMapper;

	@Override
	public Visitor tourist(String ip) {
		try{
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setIp(ip);
			loginInfo.setLoginTime(new Date());
			loginInfoMapper.insertSelective(loginInfo);
			Visitor visitor = visitorMapper.selectByPrimaryKey(1);
			return visitor;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public Visitor getVisitorById(Integer visitorId) {
		try{
			Visitor visitor = visitorMapper.selectByPrimaryKey(visitorId);
			return visitor;
		}catch(Exception e){
			throw e;
		}
	}

}
