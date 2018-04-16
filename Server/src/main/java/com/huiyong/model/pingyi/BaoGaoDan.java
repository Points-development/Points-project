/**
 * 
 */
package com.huiyong.model.pingyi;

import java.util.Date;

/**
 * @author gangpu
 *
 */
public class BaoGaoDan {
	private Integer id;
	private String userName;
	private String organization;
	private String branch;
	private String hongXian;
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
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
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
}
