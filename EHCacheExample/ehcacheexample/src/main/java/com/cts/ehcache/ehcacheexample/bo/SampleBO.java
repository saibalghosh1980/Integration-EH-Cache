package com.cts.ehcache.ehcacheexample.bo;

import java.io.Serializable;

public class SampleBO implements Serializable{

    private String userId;
    private String name;

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SampleBO(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SampleBO [name=" + name + ", userId=" + userId + "]";
    }

    

}
