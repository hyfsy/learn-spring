package com.hyf.spring6.integration.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2022/01/13
 */
@Service
public class CacheService {

	@Cacheable(value = "test", sync = true)
	public String testCacheable() {
		System.out.println("test");
		return "test";
	}

	@Cacheable(value = "test2", key = "#id")
	public String testCacheable2(Integer id) {
		System.out.println("test");
		return "test";
	}

	public String testCacheable3(Integer id) {
		return testCacheable2(id);
	}
}
