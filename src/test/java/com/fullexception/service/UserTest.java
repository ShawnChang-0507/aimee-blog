package com.fullexception.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fullexception.AliciaDoApplication;
import com.fullexception.util.SpringUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AliciaDoApplication.class)// 指定spring-boot的启动类 
public class UserTest {

	@Test
	public void test() {
		Object obj = SpringUtil.getBean("User");
	}

}
