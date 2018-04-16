/**
 * 
 */
package com.huiyong.service;

import java.util.List;

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
public interface PingYiService {
	public List<QunZhongPingYi> getQunZhongPingYis(String branch, String organization);
	public void updateQunZhongPingYis(String branch, String organization, List<QunZhongPingYi> qunZhongPingYis);
	
	public List<ZiPing> getZiPings(String branch, String organization);
	public void updateZiPings(String branch, String organization, List<ZiPing> ziPings);
	
	public List<HuPing> getHuPings(String branch, String organization);
	public void updateHuPings(String branch, String organization, List<HuPing> huPings);
	
	public List<ZuZhiPingJia> getZuZhiPingJias(String branch, String organization);
	public void updateZuZhiPingJias(String branch, String organization, List<ZuZhiPingJia> zuZhiPingJias);
	
	public List<DeFenHuiZong> getDeFenHuiZongs(String branch, String organization);
	public void updateDeFenHuiZongs(String branch, String organization, List<DeFenHuiZong> deFenHuiZongs);
	
	public List<BaoGaoDan> getBaoGaoDans(String branch);
	public void updateBaoGaoDans(List<BaoGaoDan> baoGaoDans);
}
