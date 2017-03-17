package com.pu.vo;

import java.io.Serializable;

/**
 * 
 * @author xiaozhuangping
 */
public class URoleVo implements Serializable{
	/**
	 *  
	 */
	private Long id;
	/**
	 *  角色名称
	 */
	private String name;
	/**
	 *  角色类型
	 */
	private String type;
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
	 * 角色名称
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 角色名称
     * @return String
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 角色类型
	 * @param type
	 */
	public void setType(String type){
		this.type = type;
	}
	
    /**
     * 角色类型
     * @return String
     */	
    public String getType(){
    	return type;
    }
}