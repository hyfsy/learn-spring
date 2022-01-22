package com.hyf.spring6.demo.ioc.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
// import org.springframework.beans.factory.OneselfAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author baB_hyf
 * @date 2021/11/08
 */
public class Z implements InitializingBean, DisposableBean { // , OneselfAware {

	public Z() {
		System.out.println("new");
	}

	@PostConstruct
	public void post() {
		System.out.println("@PostConstruct");
	}

	@PreDestroy
	public void pre() {
		System.out.println("@PreDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	public void initMethod() {
		System.out.println("initMethod");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod");
	}

	// @Override
	public void setOneself(Object bean) throws BeansException {
		System.out.println("@Autowired");
		System.out.println("Aware");
	}
}
