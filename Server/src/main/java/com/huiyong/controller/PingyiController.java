/**
 * 
 */
package com.huiyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.model.Message;
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
@RestController
@RequestMapping(value = "/pingyi")
public class PingyiController {
	
	@Autowired
	private PingYiService pingYiService;
	
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
    
    //返回branch内的所有党员的群众评议信息
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
}
