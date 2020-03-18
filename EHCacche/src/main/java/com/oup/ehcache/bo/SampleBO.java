package com.oup.ehcache.bo;

import java.io.Serializable;

public class SampleBO implements Serializable{
	
	private String key;
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public SampleBO(String key, byte[] content) {
		super();
		this.key = key;
		this.content = content;
	}
	
	
	
}
