package com.hyf.spring6.demo.aop.proxy.stat;

import com.hyf.spring6.demo.aop.common.UserService;

public class UserServiceProxy implements UserService {

	private final UserService userService;

	public UserServiceProxy(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean update(int id) {
		if (id == 1) {
			return userService.update(id);
		}

		return false;
	}
}
