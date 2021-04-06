package com.cts.ehcache.ehcacheexample.bl;

import java.util.UUID;

import com.cts.ehcache.ehcacheexample.bo.SampleBO;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("springManagedSampleBL")
public class SampleBL {

    @Cacheable(value = "oup-cache-allItemsCache", key = "#userId")
    public SampleBO getUser(String userId) {
        System.out.println("Inside the method");
        return new SampleBO(userId, UUID.randomUUID().toString());
    }

}
