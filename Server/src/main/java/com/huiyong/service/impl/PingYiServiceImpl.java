/**
 * 
 */
package com.huiyong.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huiyong.dao.PingYiMapper;
import com.huiyong.model.pingyi.BaoGaoDan;
import com.huiyong.model.pingyi.DeFenHuiZong;
import com.huiyong.model.pingyi.HuPing;
import com.huiyong.model.pingyi.QunZhongPingYi;
import com.huiyong.model.pingyi.ZiPing;
import com.huiyong.model.pingyi.ZuZhiPingJia;
import com.huiyong.service.PingYiService;

/**
 * @author gangpu
 *
 */
@Service
public class PingYiServiceImpl implements PingYiService{
	
	@Autowired
	private PingYiMapper pingYiDao;

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getQunZhongPingYis(java.lang.String)
	 */
	@Override
	public List<QunZhongPingYi> getQunZhongPingYis(String branch, String organization) {
		return pingYiDao.getQunZhongPingYis(branch, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateQunZhongPingYis(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateQunZhongPingYis(String branch, String organization, List<QunZhongPingYi> qunZhongPingYis) {
		pingYiDao.deleteQunZhongPingYis(branch, organization);
		for(QunZhongPingYi q : qunZhongPingYis){
			q.setLastModifiedTime(new Date());
		}
		pingYiDao.insertQunZhongPingYis(qunZhongPingYis);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getZiPings(java.lang.String)
	 */
	@Override
	public List<ZiPing> getZiPings(String branch, String organization) {
		return pingYiDao.getZiPings(branch, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateZiPings(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateZiPings(String branch, String organization, List<ZiPing> ziPings) {
		pingYiDao.deleteZiPings(branch, organization);
		for(ZiPing q : ziPings){
			q.setLastModifiedTime(new Date());
		}
		pingYiDao.insertZiPings(ziPings);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getHuPings(java.lang.String)
	 */
	@Override
	public List<HuPing> getHuPings(String branch, String organization) {
		return pingYiDao.getHuPings(branch, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateHuPings(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateHuPings(String branch, String organization, List<HuPing> huPings) {
		pingYiDao.deleteHuPings(branch, organization);
		for(HuPing q : huPings){
			q.setLastModifiedTime(new Date());
		}
		pingYiDao.insertHuPings(huPings);	
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getZuZhiPingJias(java.lang.String)
	 */
	@Override
	public List<ZuZhiPingJia> getZuZhiPingJias(String branch, String organization) {
		return pingYiDao.getZuZhiPingJias(branch, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateZuZhiPingJias(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateZuZhiPingJias(String branch, String organization, List<ZuZhiPingJia> zuZhiPingJias) {
		pingYiDao.deleteZuZhiPingJias(branch, organization);
		for(ZuZhiPingJia z : zuZhiPingJias){
			z.setLastModifiedTime(new Date());
		}
		pingYiDao.insertZuZhiPingJias(zuZhiPingJias);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getDeFenHuiZongs(java.lang.String)
	 */
	@Override
	public List<DeFenHuiZong> getDeFenHuiZongs(String branch, String organization) {
		return pingYiDao.getDeFenHuiZongs(branch, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateDeFenHuiZongs(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateDeFenHuiZongs(String branch, String organization, List<DeFenHuiZong> deFenHuiZongs) {
		pingYiDao.deleteDeFenHuiZongs(branch, organization);
		for(DeFenHuiZong z : deFenHuiZongs){
			z.setLastModifiedTime(new Date());
		}
		pingYiDao.insertDeFenHuiZongs(deFenHuiZongs);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getBaoGaoDans(java.lang.String)
	 */
	@Override
	public BaoGaoDan getBaoGaoDan(String username) {
		return pingYiDao.getBaoGaoDan(username) ;
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateBaoGaoDans(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public  void updateBaoGaoDan(String username, BaoGaoDan baoGaoDan) {
		pingYiDao.deleteBaoGaoDan(username);
		baoGaoDan.setLastModifiedTime(new Date());
		pingYiDao.insertBaoGaoDan(baoGaoDan);
	}

}
