package com.huiyong.model.pingyi;

import java.util.List;

public class HuPingBaoGaoDan {
	private String userName;
	private String realName;
	private List<CategoryPoint> huPingPoints;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public List<CategoryPoint> getHuPingPoints() {
		return huPingPoints;
	}
	public void setHuPingPoints(List<CategoryPoint> huPingPoints) {
		this.huPingPoints = huPingPoints;
	}
}
