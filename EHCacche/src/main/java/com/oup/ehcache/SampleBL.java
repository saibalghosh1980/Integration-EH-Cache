package com.oup.ehcache;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.oup.ehcache.bo.SampleBO;

@Service("springManagedSampleBL")
public class SampleBL {
	
	private final String keyForCache=UUID.randomUUID().toString();

	@Cacheable(value = "oup-cache-allItemsCache", key = "{'master-data'}")
	public ArrayList<SampleBO> getAll() throws IOException {
		ArrayList<SampleBO> allItems = new ArrayList<>();
		byte[] content = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\SKG\\1"));
		for (int iCounter = 0; iCounter < 5; iCounter++) {
			System.out.println("--------Adding the BO------" + iCounter);

			SampleBO sampleBO = new SampleBO(UUID.randomUUID().toString(), content);
			allItems.add(sampleBO);

		}

		System.out.println("returning items " + allItems.size());
		return allItems;

	}

}
