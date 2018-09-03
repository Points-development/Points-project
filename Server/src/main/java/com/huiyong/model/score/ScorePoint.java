/**
 * 
 */
package com.huiyong.model.score;

import java.util.Date;

/**
 * @author gangpu
 *
 */
public class ScorePoint {
	private String username;
	private String realname;
	private int selfPoint;
	private int otherPoint;
	private Date lastModifiedTime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSelfPoint() {
		return selfPoint;
	}
	public void setSelfPoint(int selfPoint) {
		this.selfPoint = selfPoint;
	}
	public int getOtherPoint() {
		return otherPoint;
	}
	public void setOtherPoint(int otherPoint) {
		this.otherPoint = otherPoint;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
