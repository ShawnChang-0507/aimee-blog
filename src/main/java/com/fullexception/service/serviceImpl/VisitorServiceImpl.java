package com.fullexception.service.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public Map<String, String> register(String loginName, String loginPassword, String nickName) {
		try{
			Visitor visitor = visitorMapper.getVisitorByLoginName(loginName);
			Map<String, String> map = new HashMap<String, String>();
			if (visitor != null){
				map.put("mes", "咦？萌妹在村里记事簿上发现相同的用户名！被人抢先了！再想个更帅的名字！o(╥﹏╥)o");
				map.put("res", "false");
			}else{
				Visitor record = new Visitor();
				record.setLoginName(loginName);
				record.setLoginPassword(loginPassword);
				record.setNickName(nickName);
				record.setCreateDate(new Date());
				visitorMapper.insertSelective(record);
				map.put("mes", "您现在已经是“人见人爱花见花开车间车爆胎”的冉萌村的超级无敌炫酷VIP啦！(福利：坐着就可以参观整个冉萌村，酒水瓜子免费~)(#^.^#)");
				map.put("res", "true");
			}
			return map;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public Visitor login(String loginName, String loginPassword) {
		try{
			Map<String, String> map = new HashMap<String, String>();
			map.put("loginName", loginName);
			map.put("loginPassword", loginPassword);
			Visitor visitor = visitorMapper.getVisitorByNameAndPass(map);
			return visitor;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public void appendLoginInfo(LoginInfo loginInfo) {
		try{
			loginInfoMapper.insertSelective(loginInfo);
		}catch(Exception e){
			throw e;
		}
	}

}
