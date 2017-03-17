package com.dao.vo;

import java.io.Serializable;

/**
 * 
 * @author xiaozhuangping
 */
public class UUserVo implements Serializable{
	/**
	 *  
	 */
	private Long id;
	/**
	 *  用户昵称
	 */
	private String nickname;
	/**
	 *  邮箱
	 */
	private String email;
	/**
	 *  密码
	 */
	private String pswd;
	/**
	 *  创建时间
	 */
	private java.util.Date createTime;
	/**
	 *  最后登录时间
	 */
	private java.util.Date lastLoginTime;
	/**
	 *  1:有效，0:禁止登录
	 */
	private Long status;
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
	 * 用户昵称
	 * @param nickname
	 */
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	
    /**
     * 用户昵称
     * @return String
     */	
    public String getNickname(){
    	return nickname;
    }
	/**
	 * 邮箱
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
    /**
     * 邮箱
     * @return String
     */	
    public String getEmail(){
    	return email;
    }
	/**
	 * 密码
	 * @param pswd
	 */
	public void setPswd(String pswd){
		this.pswd = pswd;
	}
	
    /**
     * 密码
     * @return String
     */	
    public String getPswd(){
    	return pswd;
    }
	/**
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
    /**
     * 创建时间
     * @return java.util.Date
     */	
    public java.util.Date getCreateTime(){
    	return createTime;
    }
	/**
	 * 最后登录时间
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(java.util.Date lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}
	
    /**
     * 最后登录时间
     * @return java.util.Date
     */	
    public java.util.Date getLastLoginTime(){
    	return lastLoginTime;
    }
	/**
	 * 1:有效，0:禁止登录
	 * @param status
	 */
	public void setStatus(Long status){
		this.status = status;
	}
	
    /**
     * 1:有效，0:禁止登录
     * @return Long
     */	
    public Long getStatus(){
    	return status;
    }
}