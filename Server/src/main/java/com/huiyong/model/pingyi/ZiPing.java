/**
 * 
 */
package com.huiyong.model.pingyi;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gangpu
 *
 */
public class ZiPing {
	@JsonIgnore
	private Integer id;
	private String userName;
	private String realName;
	private Integer gongXing;
	private Integer geXing;
	private Integer total;
	private String problem;
	private Date lastModifiedTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGongXing() {
		return gongXing;
	}
	public void setGongXing(Integer gongXing) {
		this.gongXing = gongXing;
	}
	public Integer getGeXing() {
		return geXing;
	}
	public void setGeXing(Integer geXing) {
		this.geXing = geXing;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

}
