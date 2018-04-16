/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.pingyi.BaoGaoDan;
import com.huiyong.model.pingyi.DeFenHuiZong;
import com.huiyong.model.pingyi.HuPing;
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
	public void insertHuPings(@Param(value = "huPings")List<HuPing> huPings);
	public void deleteHuPings(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	public List<ZuZhiPingJia> getZuZhiPingJias(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	public void insertZuZhiPingJias(@Param(value = "zuZhiPingJias")List<ZuZhiPingJia> zuZhiPingJias);
	public void deleteZuZhiPingJias(@Param(value = "branch")String branch, @Param(value = "organization")String organization);
	
	public List<DeFenHuiZong> getDeFenHuiZongs(String branch);
	public void insertDeFenHuiZongs(List<DeFenHuiZong> deFenHuiZongs);
	
	public List<BaoGaoDan> getBaoGaoDans(String branch);
	public void insertBaoGaoDans(List<BaoGaoDan> baoGaoDans);


}