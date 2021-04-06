package com.cts.ehcache.ehcacheexample;

import com.cts.ehcache.ehcacheexample.bo.SampleBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EhcacheexampleApplication {

	@Autowired
	private CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(EhcacheexampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner2(ApplicationContext ctx) {
		return args->{
			//Access cache instance by name
			Cache cache = cacheManager.getCache("oup-cache-allItemsCache");
			cache.put("1", new SampleBO("1", "Bruce Wayne"));
			cache.put("2", new SampleBO("1", "Clark Kent"));
			cache.put("3", new SampleBO("1", "Barry Allen"));
		};
	}

}
