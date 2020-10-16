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
public class ZuZhiPingJia{
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
	@CategoryInfo(description="理想信念", categoryId=1)
	private Integer liXiangXinNian;
	@CategoryInfo(description="政治意识", categoryId=2)
	private Integer zhengZhiYiShi;
	@CategoryInfo(description="学习意识", categoryId=3)
	private Integer xueXiYiShi;
	@CategoryInfo(description="遵守组织纪律", categoryId=4)
	private Integer zuZhiJiLv;
	@CategoryInfo(description="大局意识", categoryId=5)
	private Integer daJuYiShi;
	@CategoryInfo(description="工作作风", categoryId=6)
	private Integer gongZuoZuoFeng;
	@CategoryInfo(description="道德品行", categoryId=7)
	private Integer daoDePinXing;
	@CategoryInfo(description="生活作风", categoryId=8)
	private Integer shengHuoZuoFeng;
	@CategoryInfo(description="服务奉献意识", categoryId=9)
	private Integer fuWuYiShi;
	@CategoryInfo(description="履行党员义务", categoryId=10)
	private Integer lvXingDangYuanYiWu;
	@CategoryInfo(description="先锋模范作用发挥", categoryId=11)
	private Integer xianFengMoFanZuoYongFaHui;
	public Integer getLiXiangXinNian() {
		return liXiangXinNian;
	}
	public void setLiXiangXinNian(Integer liXiangXinNian) {
		this.liXiangXinNian = liXiangXinNian;
	}
	public Integer getZhengZhiYiShi() {
		return zhengZhiYiShi;
	}
	public void setZhengZhiYiShi(Integer zhengZhiYiShi) {
		this.zhengZhiYiShi = zhengZhiYiShi;
	}
	public Integer getXueXiYiShi() {
		return xueXiYiShi;
	}
	public void setXueXiYiShi(Integer xueXiYiShi) {
		this.xueXiYiShi = xueXiYiShi;
	}
	public Integer getZuZhiJiLv() {
		return zuZhiJiLv;
	}
	public void setZuZhiJiLv(Integer zuZhiJiLv) {
		this.zuZhiJiLv = zuZhiJiLv;
	}
	public Integer getDaJuYiShi() {
		return daJuYiShi;
	}
	public void setDaJuYiShi(Integer daJuYiShi) {
		this.daJuYiShi = daJuYiShi;
	}
	public Integer getGongZuoZuoFeng() {
		return gongZuoZuoFeng;
	}
	public void setGongZuoZuoFeng(Integer gongZuoZuoFeng) {
		this.gongZuoZuoFeng = gongZuoZuoFeng;
	}
	public Integer getDaoDePinXing() {
		return daoDePinXing;
	}
	public void setDaoDePinXing(Integer daoDePinXing) {
		this.daoDePinXing = daoDePinXing;
	}
	public Integer getShengHuoZuoFeng() {
		return shengHuoZuoFeng;
	}
	public void setShengHuoZuoFeng(Integer shengHuoZuoFeng) {
		this.shengHuoZuoFeng = shengHuoZuoFeng;
	}
	public Integer getFuWuYiShi() {
		return fuWuYiShi;
	}
	public void setFuWuYiShi(Integer fuWuYiShi) {
		this.fuWuYiShi = fuWuYiShi;
	}
	public Integer getLvXingDangYuanYiWu() {
		return lvXingDangYuanYiWu;
	}
	public void setLvXingDangYuanYiWu(Integer lvXingDangYuanYiWu) {
		this.lvXingDangYuanYiWu = lvXingDangYuanYiWu;
	}
	public Integer getXianFengMoFanZuoYongFaHui() {
		return xianFengMoFanZuoYongFaHui;
	}
	public void setXianFengMoFanZuoYongFaHui(Integer xianFengMoFanZuoYongFaHui) {
		this.xianFengMoFanZuoYongFaHui = xianFengMoFanZuoYongFaHui;
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
