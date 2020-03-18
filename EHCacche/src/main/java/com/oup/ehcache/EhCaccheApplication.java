package com.oup.ehcache;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.slf4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.oup.ehcache.bo.SampleBO;

@SpringBootApplication
public class EhCaccheApplication {
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	HashMap<String, SampleBO> tempStorage = new HashMap<String, SampleBO>();

	public static void main(String[] args) {
		SpringApplication.run(EhCaccheApplication.class, args);
	}

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	@Qualifier("springManagedSampleBL")
	private SampleBL sampleBL;
    
	
	@Bean
	public CommandLineRunner commandLineRunner2(ApplicationContext ctx) {
		return args->{
			sampleBL.getAll();
			logger.debug("Calling second time------------");
			sampleBL.getAll();
			logger.debug("Calling third time------------");
			sampleBL.getAll();
			logger.debug("Calling fourth time------------");
			sampleBL.getAll();
			logger.debug("Flushing the cache");
			cacheManager.getCache("oup-cache-allItemsCache").invalidate();
			logger.debug("Cache flushed");
			logger.debug("Calling fifth time------------");
			sampleBL.getAll();
		};
	}
	
    @SuppressWarnings("unused")
	//@Bean
	public CommandLineRunner commandLineRunner1(ApplicationContext ctx) {
		return args -> {

			byte[] content = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\SKG\\1"));

			Cache cache = cacheManager.getCache("oup-cache-advantageFeedsCache");
			for (int iRun = 0; iRun < 5; iRun++) {
				ArrayList<String> keys = new ArrayList<>();
				for (int iCounter = 0; iCounter < 7; iCounter++) {

					SampleBO sampleBO = new SampleBO(UUID.randomUUID().toString(), content);
					// tempStorage.put(sampleBO.getKey(), sampleBO);
					cache.put(sampleBO.getKey(), sampleBO);					
					keys.add(sampleBO.getKey());
					System.out.println("Adding.....");
					
				}

				
				//Get all elements from cache -->https://stackoverflow.com/questions/11829383/how-to-iterate-on-a-cache-entries/11829972
				keys.forEach(item -> {
                    
					if (cache.get(item) != null) {
						System.out.println(item);
					}
					else
					{
						System.out.println("Item not found:"+item);
					}
				});				
                
				cache.invalidate();
				Thread.sleep(30000);
				

			}
			// Thread.sleep(300000);

		};
	}

}
