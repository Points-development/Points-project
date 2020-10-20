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
	private String name;
	private String realName;
	private int selfPoint;
	private int otherPoint;
	private Date lastModifiedTime;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
