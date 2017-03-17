package com.pu.vo;

import java.io.Serializable;

/**
 * 
 * @author xiaozhuangping
 */
public class UPermissionVo implements Serializable{
	/**
	 *  
	 */
	private Long id;
	/**
	 *  url地址
	 */
	private String url;
	/**
	 *  url描述
	 */
	private String name;
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * 
     * @return Long
     */	
    public Long getId(){
    	return id;
    }
	/**
	 * url地址
	 * @param url
	 */
	public void setUrl(String url){
		this.url = url;
	}
	
    /**
     * url地址
     * @return String
     */	
    public String getUrl(){
    	return url;
    }
	/**
	 * url描述
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * url描述
     * @return String
     */	
    public String getName(){
    	return name;
    }
}