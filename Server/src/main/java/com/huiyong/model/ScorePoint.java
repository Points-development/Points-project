/**
 * 
 */
package com.huiyong.model;

/**
 * @author gangpu
 *
 */
public class ScorePoint {
	private String username;
	private int selfPoint;
	private int otherPoint;
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
}
