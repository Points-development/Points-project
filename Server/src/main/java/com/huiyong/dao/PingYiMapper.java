/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.pingyi.BaoGaoDan;
import com.huiyong.model.pingyi.CategoryIssue;
import com.huiyong.model.pingyi.CategoryPoint;
import com.huiyong.model.pingyi.DeFenHuiZong;
import com.huiyong.model.pingyi.HuPing;
import com.huiyong.model.pingyi.PartyHistory;
import com.huiyong.model.pingyi.QunZhongPingYi;
import com.huiyong.model.pingyi.ZiPing;
import com.huiyong.model.pingyi.ZuZhiPingJia;

/**
 * @author gangpu
 *
 */
public interface PingYiMapper {
	public List<QunZhongPingYi> getQunZhongPingYis(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void insertQunZhongPingYis(@Param(value = "qunZhongPingYis")List<QunZhongPingYi> qunZhongPingYis);
	public void deleteQunZhongPingYis(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	public List<ZiPing> getZiPings(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void insertZiPings(@Param(value = "ziPings")List<ZiPing> ziPings);
	public void deleteZiPings(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	
	public List<HuPing> getHuPings(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public String getHuPingAnswerByUser(@Param(value = "username")String username);
	public void insertHuPings(@Param(value = "huPings")List<HuPing> huPings);
	public void deleteHuPings(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	public List<ZuZhiPingJia> getZuZhiPingJias(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void insertZuZhiPingJias(@Param(value = "zuZhiPingJias")List<ZuZhiPingJia> zuZhiPingJias);
	public void deleteZuZhiPingJias(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	public List<DeFenHuiZong> getDeFenHuiZongs(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void insertDeFenHuiZongs(@Param(value = "deFenHuiZongs")List<DeFenHuiZong> deFenHuiZongs);
	public void deleteDeFenHuiZongs(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	public BaoGaoDan getBaoGaoDan(@Param(value = "username")String username);
	public BaoGaoDan deleteBaoGaoDan(@Param(value = "username")String username);
	public void insertBaoGaoDan(@Param(value = "username")String username, @Param(value = "baoGaoDan")BaoGaoDan baoGaoDan);
	public List<CategoryPoint> getZiPingCategoryPoint(@Param(value = "username")String username);
	public List<CategoryPoint> getHuPingCategoryPoint(@Param(value = "username")String username);
	public ZuZhiPingJia getZuZhiPingJiaByUser(@Param(value = "username")String username);
	public QunZhongPingYi getQunZhongPingJiaByUser(String username);
	public List<CategoryIssue> getCategoryIssue(@Param(value = "username")String username);
	public List<CategoryIssue> initCategoryIssue(@Param(value = "username")String username);
	public void insertZuZhiPingJia(ZuZhiPingJia zuZhiPingJia);
	public void updateZuZhiPingJia(ZuZhiPingJia zuZhiPingJia);
	public void updateQunZhongPingYi(QunZhongPingYi qunZhongPingYi);
	public void insertQunZhongPingYi(QunZhongPingYi qunZhongPingYi);
	public List<PartyHistory> getPartyHistorys(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void deletePartyHistorys(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void insertPartyHistorys(@Param(value = "partyHistorys")List<PartyHistory> partyHistorys);
	public Integer getPartyHistoryByUser(@Param(value = "username")String username);
}
