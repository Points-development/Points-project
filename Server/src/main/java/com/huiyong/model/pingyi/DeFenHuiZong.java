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
public class DeFenHuiZong {
	@JsonIgnore
	private Integer id;
	private String userName;
	private String realName;
	private Integer ziPing;
	private Integer huPing;
	private Integer qunZhongPing;
	private Integer zuZhiPing;
	private Integer total;
	
	private Integer givenValue;
	
	private Integer lastTotal;
	
	private Integer lastGivenValue;
	
	private Integer zhengZhiGivenValue;
	
	private Integer plusItem;
	
	private Integer minusItem;
	
	private Integer totalPlus;
	private String hongXian;
	private String jianKang;
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
	public Integer getZiPing() {
		return ziPing;
	}
	public void setZiPing(Integer ziPing) {
		this.ziPing = ziPing;
	}
	public Integer getHuPing() {
		return huPing;
	}
	public void setHuPing(Integer huPing) {
		this.huPing = huPing;
	}
	public Integer getQunZhongPing() {
		return qunZhongPing;
	}
	public void setQunZhongPing(Integer qunZhongPing) {
		this.qunZhongPing = qunZhongPing;
	}
	public Integer getZuZhiPing() {
		return zuZhiPing;
	}
	public void setZuZhiPing(Integer zuZhiPing) {
		this.zuZhiPing = zuZhiPing;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getHongXian() {
		return hongXian;
	}
	public void setHongXian(String hongXian) {
		this.hongXian = hongXian;
	}
	public String getJianKang() {
		return jianKang;
	}
	public void setJianKang(String jianKang) {
		this.jianKang = jianKang;
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
	public Integer getLastTotal() {
		return lastTotal;
	}
	public void setLastTotal(Integer lastTotal) {
		this.lastTotal = lastTotal;
	}
	
	public Integer getGivenValue() {
		return givenValue;
	}
	public void setGivenValue(Integer givenValue) {
		this.givenValue = givenValue;
	}
	public Integer getLastGivenValue() {
		return lastGivenValue;
	}
	public void setLastGivenValue(Integer lastGivenValue) {
		this.lastGivenValue = lastGivenValue;
	}
	public Integer getZhengZhiGivenValue() {
		return zhengZhiGivenValue;
	}
	public void setZhengZhiGivenValue(Integer zhengZhiGivenValue) {
		this.zhengZhiGivenValue = zhengZhiGivenValue;
	}
	public Integer getPlusItem() {
		return plusItem;
	}
	public void setPlusItem(Integer plusItem) {
		this.plusItem = plusItem;
	}
	public Integer getMinusItem() {
		return minusItem;
	}
	public void setMinusItem(Integer minusItem) {
		this.minusItem = minusItem;
	}
	public Integer getTotalPlus() {
		return totalPlus;
	}
	public void setTotalPlus(Integer totalPlus) {
		this.totalPlus = totalPlus;
	}
}
