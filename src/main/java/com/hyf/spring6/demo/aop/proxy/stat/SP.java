package com.hyf.spring6.demo.aop.proxy.stat;

import com.hyf.spring6.demo.aop.common.UserService;
import com.hyf.spring6.demo.aop.common.UserServiceImpl;

public class SP {

	public static void main(String[] args) {

		// target
		UserService userService = new UserServiceImpl();

		UserService userServiceProxy = new UserServiceProxy(userService);

		userServiceProxy.update(1);
	}
}
