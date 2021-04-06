package com.cts.ehcache.ehcacheexample.controller;

import com.cts.ehcache.ehcacheexample.bl.SampleBL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
	@Qualifier("springManagedSampleBL")
	private SampleBL sampleBL;

    @GetMapping("/name/{id}")
    public String getUserName(@PathVariable(name = "id") String id){

        return sampleBL.getUser(id).getName();

    }
    
}
