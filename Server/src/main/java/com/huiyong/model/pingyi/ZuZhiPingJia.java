/**
 * 
 */
package com.huiyong.model.pingyi;

import java.util.Date;

/**
 * @author gangpu
 *
 */
public class ZuZhiPingJia {
	private Integer id;
	private String userName;
	private String realName;
	private Integer zhengZhi;
	private Integer zuZhi;
	private Integer daoDe;
	private Integer lvXingYiWu;
	private Integer moFan;
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
	public Integer getZhengZhi() {
		return zhengZhi;
	}
	public void setZhengZhi(Integer zhengZhi) {
		this.zhengZhi = zhengZhi;
	}
	public Integer getZuZhi() {
		return zuZhi;
	}
	public void setZuZhi(Integer zuZhi) {
		this.zuZhi = zuZhi;
	}
	public Integer getDaoDe() {
		return daoDe;
	}
	public void setDaoDe(Integer daoDe) {
		this.daoDe = daoDe;
	}
	public Integer getLvXingYiWu() {
		return lvXingYiWu;
	}
	public void setLvXingYiWu(Integer lvXingYiWu) {
		this.lvXingYiWu = lvXingYiWu;
	}
	public Integer getMoFan() {
		return moFan;
	}
	public void setMoFan(Integer moFan) {
		this.moFan = moFan;
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
	/**
	 * @return the lastModifiedTime
	 */
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	/**
	 * @param lastModifiedTime the lastModifiedTime to set
	 */
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
