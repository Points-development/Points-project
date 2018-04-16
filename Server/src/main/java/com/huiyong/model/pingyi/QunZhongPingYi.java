/**
 * 
 */
package com.huiyong.model.pingyi;

import java.util.Date;

/**
 * @author gangpu
 *
 */
public class QunZhongPingYi {
	private Integer id;
	private String userName;
	private String realName;
	private Integer siXiang;
	private Integer daoDe;
	private Integer xueXi;
	private Integer gongZuo;
	private Integer shengHuo;
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
	public Integer getSiXiang() {
		return siXiang;
	}
	public void setSiXiang(Integer siXiang) {
		this.siXiang = siXiang;
	}
	public Integer getDaoDe() {
		return daoDe;
	}
	public void setDaoDe(Integer daoDe) {
		this.daoDe = daoDe;
	}
	public Integer getXueXi() {
		return xueXi;
	}
	public void setXueXi(Integer xueXi) {
		this.xueXi = xueXi;
	}
	public Integer getShengHuo() {
		return shengHuo;
	}
	public void setShengHuo(Integer shengHuo) {
		this.shengHuo = shengHuo;
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
	/**
	 * @return the gongZuo
	 */
	public Integer getGongZuo() {
		return gongZuo;
	}
	/**
	 * @param gongZuo the gongZuo to set
	 */
	public void setGongZuo(Integer gongZuo) {
		this.gongZuo = gongZuo;
	}

}
