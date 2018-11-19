package com.fullexception.config;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.fullexception.entity.Visitor;
import com.fullexception.service.VisitorService;

public class MyShiroRealm extends AuthorizingRealm{

	@Resource
	private VisitorService visitorService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		Visitor visitor = visitorService.findByUsername(userName);
		if (visitor == null){
			return  null;
		}
		if (visitor.getVisitorStateId() == 0){
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				visitor.getLoginName(),
				visitor.getLoginPassword(),
				getName()
				);
		
		return authenticationInfo;
	}

}
