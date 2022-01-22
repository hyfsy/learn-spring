package com.hyf.spring6.demo.aop.common;

public class UserServiceImpl implements UserService {

	@Override
	public boolean update(int id) {
		System.out.println("update success: " + id);
		return true;
	}
}
