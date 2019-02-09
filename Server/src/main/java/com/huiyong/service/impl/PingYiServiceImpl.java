/**
 * 
 */
package com.huiyong.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huiyong.dao.PingYiMapper;
import com.huiyong.model.pingyi.BaoGaoDan;
import com.huiyong.model.pingyi.CategoryInfo;
import com.huiyong.model.pingyi.CategoryPoint;
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
		List<HuPing> huPingList = pingYiDao.getHuPings(branch, organization);
		for(HuPing huPing : huPingList){
			if(null == huPing.getProblem()){
				huPing.setProblem(pingYiDao.getHuPingAnswerByUser(huPing.getUserName()));
			}
		}
		return huPingList;
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
	
	private CategoryPoint getZongHePingJia(List<CategoryPoint> categoryPoints){
		CategoryPoint zongHe = new CategoryPoint();
		zongHe.setPoint(categoryPoints.stream().filter(x->(null !=x.getPoint())).mapToInt(x->x.getPoint()).sum());
		zongHe.setDescription("综合评价");
		zongHe.setCategoryId(categoryPoints.size() + 1);
		return zongHe;
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#getBaoGaoDans(java.lang.String)
	 */
	@Override
	public BaoGaoDan getBaoGaoDan(String username) throws Exception {
		double ziPingPortion=0.2, huPingPortion=0.3, zuZhiPingPortion=0.3, qunZhongPingPortion=0.2;
		//85以上为健康，60-85为亚健康，否则为不健康。 返回值0表示不健康，50表示亚健康，100表示健康
		int health = 85, subhealth = 60;
		BaoGaoDan baoGaoDan = pingYiDao.getBaoGaoDan(username);
		List<CategoryPoint> ziPingPoints = pingYiDao.getZiPingCategoryPoint(username);
		ziPingPoints.add(getZongHePingJia(ziPingPoints));
		baoGaoDan.setZiPingPoints(ziPingPoints);
		List<CategoryPoint> huPingPoints = pingYiDao.getHuPingCategoryPoint(username);
		huPingPoints.add(getZongHePingJia(huPingPoints));
		baoGaoDan.setHuPingPoints(huPingPoints);
		List<CategoryPoint> qunZhongPingPoints = transferQunZhongPing(pingYiDao.getQunZhongPingJiaByUser(username));
		qunZhongPingPoints.add(getZongHePingJia(qunZhongPingPoints));
		baoGaoDan.setFuWuDuiXiangPingPoints(qunZhongPingPoints);
		List<CategoryPoint> zuZhiPingPoints = transferZuZhiPing(pingYiDao.getZuZhiPingJiaByUser(username));
		zuZhiPingPoints.add(getZongHePingJia(zuZhiPingPoints));
		baoGaoDan.setZuZhiPingPoints(zuZhiPingPoints);
		List<CategoryPoint> zongHeList = new ArrayList<CategoryPoint>();
		List<CategoryPoint> jianKangList = new ArrayList<CategoryPoint>();
		for(int i=0; i<ziPingPoints.size(); i++){
			CategoryPoint zongheCP = new CategoryPoint();
			CategoryPoint jiankangCP = new CategoryPoint();
			zongheCP.setCategoryId(i+1);
			zongheCP.setDescription(ziPingPoints.get(i).getDescription());
			jiankangCP.setCategoryId(i+1);
			jiankangCP.setDescription(ziPingPoints.get(i).getDescription());
			int point = (int) Math.round(ziPingPoints.get(i).getPoint() * ziPingPortion 
					+ huPingPoints.get(i).getPoint() * huPingPortion 
					+ zuZhiPingPoints.get(i).getPoint() * zuZhiPingPortion 
					+ qunZhongPingPoints.get(i).getPoint() * qunZhongPingPortion);
			zongheCP.setPoint(point);
			if(point >= health){
				jiankangCP.setPoint(100);
			}else if(point >= subhealth){
				jiankangCP.setPoint(50);
			}else{
				jiankangCP.setPoint(0);
			}
			zongHeList.add(zongheCP);
			jianKangList.add(jiankangCP);
		}
		baoGaoDan.setZongHeDeFenPoints(zongHeList);
		baoGaoDan.setJianKangZhuangTaiPoints(jianKangList);
		return baoGaoDan;
	}

	private List<CategoryPoint> transferZuZhiPing(ZuZhiPingJia zuZhiPingJia) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = ZuZhiPingJia.class;
		Field[] fields = clazz.getDeclaredFields();
		List<CategoryPoint> cpList = new ArrayList<CategoryPoint>();
		for(Field f:fields){
			f.setAccessible(true);
			if(f.isAnnotationPresent(CategoryInfo.class)){
				CategoryPoint cp = new CategoryPoint();
				CategoryInfo ci = f.getAnnotation(CategoryInfo.class);
				cp.setCategoryId(ci.categoryId());
				cp.setDescription(ci.description());
				if(null == zuZhiPingJia){
					cp.setPoint(0);
				}else{
					cp.setPoint(Optional.ofNullable((Integer)f.get(zuZhiPingJia)).map(u->u).orElse(0));
				}
				cpList.add(cp);
			}
		}
		return cpList;
	}
	
	private List<CategoryPoint> transferQunZhongPing(QunZhongPingYi qunZhongPingJia) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = QunZhongPingYi.class;
		Field[] fields = clazz.getDeclaredFields();
		List<CategoryPoint> cpList = new ArrayList<CategoryPoint>();
		for(Field f:fields){
			f.setAccessible(true);
			if(f.isAnnotationPresent(CategoryInfo.class)){
				CategoryPoint cp = new CategoryPoint();
				CategoryInfo ci = f.getAnnotation(CategoryInfo.class);
				cp.setCategoryId(ci.categoryId());
				cp.setDescription(ci.description());
				if(null == qunZhongPingJia){
					cp.setPoint(0);
				}else{
					cp.setPoint(Optional.ofNullable((Integer)f.get(qunZhongPingJia)).map(u->u).orElse(0));
				}

				cpList.add(cp);
			}
		}
		return cpList;
	}


	/* (non-Javadoc)
	 * @see com.huiyong.service.PingYiService#updateBaoGaoDans(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public  void updateBaoGaoDan(String username, BaoGaoDan baoGaoDan) {
//		pingYiDao.deleteBaoGaoDan(username);
		baoGaoDan.setLastModifiedTime(new Date());
		pingYiDao.insertBaoGaoDan(username, baoGaoDan);
	}

}
