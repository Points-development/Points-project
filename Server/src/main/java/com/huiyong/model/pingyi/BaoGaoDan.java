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
public class BaoGaoDan {
	@JsonIgnore
	private Integer id;
	private String userName;
	private String realName;
	private String hongXian;
	private Integer deFen;
	private String tiJian;
	private String problem;
	private String tiGao;
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
	public String getHongXian() {
		return hongXian;
	}
	public void setHongXian(String hongXian) {
		this.hongXian = hongXian;
	}
	public String getTiJian() {
		return tiJian;
	}
	public void setTiJian(String tiJian) {
		this.tiJian = tiJian;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getTiGao() {
		return tiGao;
	}
	public void setTiGao(String tiGao) {
		this.tiGao = tiGao;
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
	 * @return the deFen
	 */
	public Integer getDeFen() {
		return deFen;
	}
	/**
	 * @param deFen the deFen to set
	 */
	public void setDeFen(Integer deFen) {
		this.deFen = deFen;
	}
}
