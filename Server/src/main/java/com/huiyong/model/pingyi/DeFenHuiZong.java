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
}
