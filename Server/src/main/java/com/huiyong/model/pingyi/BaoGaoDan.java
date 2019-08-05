/**
 * 
 */
package com.huiyong.model.pingyi;

import java.util.Date;
import java.util.List;

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
	private String tiJian;
	private String problem;
	private String tiGao;
	//deFen is an internal property to test whether the BaoGaoDan for a user exists
	//select count(*) from BaoGaoDan where userName = #{username} 的值赋给defen
	@JsonIgnore
	private Integer deFen;
	private Integer pingyiNumber;
	private List<CategoryPoint> ziPingPoints;
	private List<CategoryPoint> huPingPoints;
	private List<CategoryPoint> zuZhiPingPoints;
	private List<CategoryPoint> fuWuDuiXiangPingPoints;
	private List<CategoryPoint> zongHeDeFenPoints;
	private List<CategoryPoint> jianKangZhuangTaiPoints;
	private List<CategoryIssue> categoryTopIssues;
	private Date lastModifiedTime;
	public List<CategoryIssue> getCategoryTopIssues() {
		return categoryTopIssues;
	}
	public void setCategoryTopIssues(List<CategoryIssue> categoryTopIssues) {
		this.categoryTopIssues = categoryTopIssues;
	}
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public List<CategoryPoint> getZiPingPoints() {
		return ziPingPoints;
	}
	public void setZiPingPoints(List<CategoryPoint> ziPingPoints) {
		this.ziPingPoints = ziPingPoints;
	}
	public List<CategoryPoint> getHuPingPoints() {
		return huPingPoints;
	}
	public void setHuPingPoints(List<CategoryPoint> huPingPoints) {
		this.huPingPoints = huPingPoints;
	}
	public List<CategoryPoint> getZuZhiPingPoints() {
		return zuZhiPingPoints;
	}
	public void setZuZhiPingPoints(List<CategoryPoint> zuZhiPingPoints) {
		this.zuZhiPingPoints = zuZhiPingPoints;
	}
	public List<CategoryPoint> getFuWuDuiXiangPingPoints() {
		return fuWuDuiXiangPingPoints;
	}
	public void setFuWuDuiXiangPingPoints(List<CategoryPoint> fuWuDuiXiangPingPoints) {
		this.fuWuDuiXiangPingPoints = fuWuDuiXiangPingPoints;
	}
	public List<CategoryPoint> getZongHeDeFenPoints() {
		return zongHeDeFenPoints;
	}
	public void setZongHeDeFenPoints(List<CategoryPoint> zongHeDeFenPoints) {
		this.zongHeDeFenPoints = zongHeDeFenPoints;
	}
	public List<CategoryPoint> getJianKangZhuangTaiPoints() {
		return jianKangZhuangTaiPoints;
	}
	public void setJianKangZhuangTaiPoints(List<CategoryPoint> jianKangZhuangTaiPoints) {
		this.jianKangZhuangTaiPoints = jianKangZhuangTaiPoints;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
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
	public Integer getDeFen() {
		return deFen;
	}
	public void setDeFen(Integer deFen) {
		this.deFen = deFen;
	}
	public Integer getPingyiNumber() {
		return pingyiNumber;
	}
	public void setPingyiNumber(Integer pingyiNumber) {
		this.pingyiNumber = pingyiNumber;
	}


}
