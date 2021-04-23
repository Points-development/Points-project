/**
 * 
 */
package com.huiyong.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.model.Message;
import com.huiyong.model.pingyi.BaoGaoDan;
import com.huiyong.model.pingyi.CategoryPoint;
import com.huiyong.model.pingyi.DeFenHuiZong;
import com.huiyong.model.pingyi.HuPing;
import com.huiyong.model.pingyi.HuPingBaoGaoDan;
import com.huiyong.model.pingyi.PartyHistory;
import com.huiyong.model.pingyi.QunZhongPingYi;
import com.huiyong.model.pingyi.ZiPing;
import com.huiyong.model.pingyi.ZiPingBaoGaoDan;
import com.huiyong.model.pingyi.ZuZhiPingJia;
import com.huiyong.model.score.CategoryScorePoint;
import com.huiyong.model.score.Score;
import com.huiyong.model.user.User;
import com.huiyong.service.PingYiService;
import com.huiyong.service.ScoreService;
import com.huiyong.service.UserService;
import com.huiyong.util.PingYiUtil;

/**
 * @author gangpu
 *
 */
@RestController
@RequestMapping(value = "/pingyi")
public class PingyiController {
	
	@Autowired
	private PingYiService pingYiService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private UserService userService;
	
    //返回branch内的所有党员的组织评价信息
    @RequestMapping(value = "/zuzhipingjia", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getZuZhiPingJias(@RequestParam String branch, @RequestParam String organization) {
    	List<ZuZhiPingJia> zuZhiPingJias = pingYiService.getZuZhiPingJias(branch, organization);
    	return new ResponseEntity<List<ZuZhiPingJia>>(zuZhiPingJias, HttpStatus.OK);
    }
    
    //更新branch内的党员的组织评价信息
    @RequestMapping(value = "/zuzhipingjia", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateZuZhiPingJias(@RequestParam String branch, @RequestParam String organization,  @RequestBody List<ZuZhiPingJia> zuZhiPingJias) {
    	pingYiService.updateZuZhiPingJias(branch, organization, zuZhiPingJias);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //更新org内的党员的组织评价信息, 和之前的分数算平均分    
    @RequestMapping(value = "/zuzhipingjia/{username}", method = RequestMethod.POST)
    public ResponseEntity<?> addZuZhiPingJiaScore(@PathVariable String username, @RequestBody Score score) throws Exception {
    	if(null == score){
        	return new ResponseEntity<String>("Score is null.", HttpStatus.BAD_REQUEST);
    	}
    	if(null == username ){
    		return new ResponseEntity<String>("User name is null.", HttpStatus.BAD_REQUEST);
    	}
    	if(score.getPoint() >= 99 ){
    		return new ResponseEntity<String>("分数必须小于为100.", HttpStatus.BAD_REQUEST);
    	}
    	if(!username.equals(score.getScoree())){
    		return new ResponseEntity<String>("Add score to the user different from username in url.", HttpStatus.BAD_REQUEST);
    	}
    	User user = userService.getUserByName(username);
    	if(null == user){
    		return new ResponseEntity<String>("User name does not exist", HttpStatus.BAD_REQUEST);
    	}
    	//Here pass 0 as scoreId since we don't really have a score id
    	List<CategoryScorePoint> aCSPList = scoreService.getCategoryPointByScore(score, 0);
    	ZuZhiPingJia zuZhiPingJia = new ZuZhiPingJia();
    	PingYiUtil.transferCategoryPoint(aCSPList, ZuZhiPingJia.class, zuZhiPingJia);
    	zuZhiPingJia.setUserName(username);
    	zuZhiPingJia.setRealName(user.getRealName());
    	zuZhiPingJia.setProblem(score.getScores().stream().filter(z->z.getAnswer() != null).map(z->z.getAnswer())
    			.collect(Collectors.joining("")));
    	pingYiService.updateZuZhiPingJiaByUser(username, zuZhiPingJia);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回内的所有党员的群众评议信息
    @RequestMapping(value = "/qunzhongpingyi", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getQunZhongPingYis(@RequestParam String branch, @RequestParam String organization) {
    	List<QunZhongPingYi> qunZhongPingYis = pingYiService.getQunZhongPingYis(branch, organization);
    	return new ResponseEntity<List<QunZhongPingYi>>(qunZhongPingYis, HttpStatus.OK);
    }
    
    //更新branch内的党员的群众评议信息
    @RequestMapping(value = "/qunzhongpingyi", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateQunZhongPingYis(@RequestParam String branch, @RequestParam String organization,  @RequestBody List<QunZhongPingYi> qunZhongPingYis) {
    	pingYiService.updateQunZhongPingYis(branch, organization, qunZhongPingYis);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //更新branch内的党员的群众评议信息, 和之前的分数算平均分
    @RequestMapping(value = "/qunzhongpingyi/{username}", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> addQunZhongPingYiScore(@PathVariable String username, @RequestBody Score score) throws Exception {
    	if(null == score){
        	return new ResponseEntity<String>("Score is null.", HttpStatus.BAD_REQUEST);
    	}
    	if(null == username ){
    		return new ResponseEntity<String>("User name is null.", HttpStatus.BAD_REQUEST);
    	}
    	if(score.getPoint() >= 99 ){
    		return new ResponseEntity<String>("分数必须小于为100.", HttpStatus.BAD_REQUEST);
    	}
    	if(!username.equals(score.getScoree())){
    		return new ResponseEntity<String>("Add score to the user different from username in url.", HttpStatus.BAD_REQUEST);
    	}
    	User user = userService.getUserByName(username);
    	if(null == user){
    		return new ResponseEntity<String>("User name does not exist", HttpStatus.BAD_REQUEST);
    	}
    	
    	//Here pass 0 as scoreId since we don't really have a score id
    	List<CategoryScorePoint> aCSPList = scoreService.getCategoryPointByScore(score, 0);
    	QunZhongPingYi qunZhongPingYi = new QunZhongPingYi();
    	PingYiUtil.transferCategoryPoint(aCSPList, QunZhongPingYi.class, qunZhongPingYi);
    	qunZhongPingYi.setUserName(username);
    	qunZhongPingYi.setRealName(user.getRealName());
    	qunZhongPingYi.setProblem(score.getScores().stream().filter(z->z.getAnswer() != null).map(z->z.getAnswer())
    			.collect(Collectors.joining("")));
    	pingYiService.updateQunZhongPingYiByUser(username, qunZhongPingYi);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回branch内的所有党员的自评信息
    @RequestMapping(value = "/ziping", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getZiPings(@RequestParam String branch, @RequestParam String organization) {
    	List<ZiPing> ziPings = pingYiService.getZiPings(branch, organization);
    	return new ResponseEntity<List<ZiPing>>(ziPings, HttpStatus.OK);
    }
    
    //更新branch内的党员的自评信息
    @RequestMapping(value = "/ziping", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateZiPings(@RequestParam String branch, @RequestParam String organization,  @RequestBody List<ZiPing> ziPings) {
    	pingYiService.updateZiPings(branch, organization, ziPings);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回branch内的所有党员的互评信息
    @RequestMapping(value = "/huping", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getHuPings(@RequestParam String branch, @RequestParam String organization) {
    	List<HuPing> huPings = pingYiService.getHuPings(branch, organization);
    	return new ResponseEntity<List<HuPing>>(huPings, HttpStatus.OK);
    }
    
    //更新branch内的党员的互评信息
    @RequestMapping(value = "/huping", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateHuPings(@RequestParam String branch, @RequestParam String organization,  @RequestBody List<HuPing> huPings) {
    	pingYiService.updateHuPings(branch, organization, huPings);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回branch内的所有党员的党史测评信息
    @RequestMapping(value = "/partyhistory", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getPartyHistorys(@RequestParam String branch, @RequestParam String organization) {
    	List<PartyHistory> partyHistorys = pingYiService.getPartyHistorys(branch, organization);
    	return new ResponseEntity<List<PartyHistory>>(partyHistorys, HttpStatus.OK);
    }
    
    //更新branch内的党员的党史测评信息
    @RequestMapping(value = "/partyhistory", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updatePartyHistorys(@RequestParam String branch, @RequestParam String organization,  @RequestBody List<PartyHistory> partyHistorys) {
    	pingYiService.updatePartyHistorys(branch, organization, partyHistorys);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回branch内的所有党员的得分汇总信息
    @RequestMapping(value = "/defenhuizong", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getDeFenHuiZongs(@RequestParam String branch, @RequestParam String organization) {
    	List<DeFenHuiZong> deFenHuiZongs = pingYiService.getDeFenHuiZongs(branch, organization);
    	return new ResponseEntity<List<DeFenHuiZong>>(deFenHuiZongs, HttpStatus.OK);
    }
    
    //更新branch内的党员的得分汇总信息
    @RequestMapping(value = "/defenhuizong", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateDeFenHuiZongs(@RequestParam String branch, @RequestParam String organization,  @RequestBody List<DeFenHuiZong> deFenHuiZongs) {
    	pingYiService.updateDeFenHuiZongs(branch, organization, deFenHuiZongs);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回该用户的报告单信息
    @RequestMapping(value = "/baogaodan", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getBaoGaoDan(@RequestParam String username) throws Exception {
    	BaoGaoDan baoGaoDan = pingYiService.getBaoGaoDan(username);
    	return new ResponseEntity<BaoGaoDan>(baoGaoDan, HttpStatus.OK);
    }
    
    //更新该用户的报告单信息
    @RequestMapping(value = "/baogaodan", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateBaoGaoDan(@RequestParam String username, @RequestBody BaoGaoDan baoGaoDan) {
    	pingYiService.updateBaoGaoDan(username, baoGaoDan);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回该用户的自评报告单信息
    @RequestMapping(value = "/baogaodan/self", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getZiPingBaoGaoDan(@RequestParam String username) throws Exception {
    	ZiPingBaoGaoDan baoGaoDan = new ZiPingBaoGaoDan();
    	List<CategoryPoint> alist = pingYiService.getZiPingBaoGaoDan(username);
    	baoGaoDan.setUserName(username);
    	baoGaoDan.setZiPingPoints(alist);
    	return new ResponseEntity<ZiPingBaoGaoDan>(baoGaoDan, HttpStatus.OK);
    }
    
    //返回该用户的互评报告单信息
    @RequestMapping(value = "/baogaodan/other", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getHuPingBaoGaoDan(@RequestParam String username) throws Exception {
    	HuPingBaoGaoDan baoGaoDan = new HuPingBaoGaoDan();
    	List<CategoryPoint> alist = pingYiService.getHuPingBaoGaoDan(username);
    	baoGaoDan.setUserName(username);
    	baoGaoDan.setHuPingPoints(alist);
    	return new ResponseEntity<HuPingBaoGaoDan>(baoGaoDan, HttpStatus.OK);
    }
}
