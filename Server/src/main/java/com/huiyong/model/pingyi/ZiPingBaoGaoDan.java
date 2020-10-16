package com.huiyong.model.pingyi;

import java.util.List;

public class ZiPingBaoGaoDan {
	private String userName;
	private List<CategoryPoint> ziPingPoints;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<CategoryPoint> getZiPingPoints() {
		return ziPingPoints;
	}
	public void setZiPingPoints(List<CategoryPoint> ziPingPoints) {
		this.ziPingPoints = ziPingPoints;
	}
}
