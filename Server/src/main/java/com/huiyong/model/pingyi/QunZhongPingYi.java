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
public class QunZhongPingYi{
	@JsonIgnore
	private Integer updateTimes = 0;
	
	public Integer getUpdateTimes() {
		return updateTimes;
	}
	public void setUpdateTimes(Integer updateTimes) {
		this.updateTimes = updateTimes;
	}
	@JsonIgnore
	private Integer id;
	private String userName;
	private String realName;
	private Integer total;
	private String problem;
	private Date lastModifiedTime;

	@CategoryInfo(description="把准政治方向", categoryId=1)
	private Integer zhengZhiFangXiang;
	@CategoryInfo(description="加强党的政治领导", categoryId=2)
	private Integer zhengZhiLingDao;
	@CategoryInfo(description="夯实政治根基", categoryId=3)
	private Integer zhengZhiGenJi;
	@CategoryInfo(description="涵养政治生态", categoryId=4)
	private Integer zhengZhiShengTai;
	@CategoryInfo(description="防范政治风险", categoryId=5)
	private Integer zhengZhiFengXian;
	@CategoryInfo(description="永葆政治本色", categoryId=6)
	private Integer zhengZhiBenSe;
	@CategoryInfo(description="提高政治能力", categoryId=7)
	private Integer zhengZhiNengLi;
	@CategoryInfo(description="先锋模范作用发挥", categoryId=8)
	private Integer xianFengMoFan;


	public Integer getXianFengMoFan() {
		return xianFengMoFan;
	}
	public void setXianFengMoFan(Integer xianFengMoFan) {
		this.xianFengMoFan = xianFengMoFan;
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
	public Integer getZhengZhiFangXiang() {
		return zhengZhiFangXiang;
	}
	public void setZhengZhiFangXiang(Integer zhengZhiFangXiang) {
		this.zhengZhiFangXiang = zhengZhiFangXiang;
	}
	public Integer getZhengZhiLingDao() {
		return zhengZhiLingDao;
	}
	public void setZhengZhiLingDao(Integer zhengZhiLingDao) {
		this.zhengZhiLingDao = zhengZhiLingDao;
	}
	public Integer getZhengZhiGenJi() {
		return zhengZhiGenJi;
	}
	public void setZhengZhiGenJi(Integer zhengZhiGenJi) {
		this.zhengZhiGenJi = zhengZhiGenJi;
	}
	public Integer getZhengZhiShengTai() {
		return zhengZhiShengTai;
	}
	public void setZhengZhiShengTai(Integer zhengZhiShengTai) {
		this.zhengZhiShengTai = zhengZhiShengTai;
	}
	public Integer getZhengZhiFengXian() {
		return zhengZhiFengXian;
	}
	public void setZhengZhiFengXian(Integer zhengZhiFengXian) {
		this.zhengZhiFengXian = zhengZhiFengXian;
	}
	public Integer getZhengZhiBenSe() {
		return zhengZhiBenSe;
	}
	public void setZhengZhiBenSe(Integer zhengZhiBenSe) {
		this.zhengZhiBenSe = zhengZhiBenSe;
	}
	public Integer getZhengZhiNengLi() {
		return zhengZhiNengLi;
	}
	public void setZhengZhiNengLi(Integer zhengZhiNengLi) {
		this.zhengZhiNengLi = zhengZhiNengLi;
	}
}
