/**
 * 
 */
package com.huiyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.model.Message;
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
    @RequestMapping(value = "/{organization}/{branch}/zuzhipingjia", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getZuZhiPingJias(@PathVariable String branch, @PathVariable String organization) {
    	List<ZuZhiPingJia> zuZhiPingJias = pingYiService.getZuZhiPingJias(branch, organization);
    	return new ResponseEntity<List<ZuZhiPingJia>>(zuZhiPingJias, HttpStatus.OK);
    }
    
    //更新branch内的党员的组织评价信息
    @RequestMapping(value = "/{organization}/{branch}/zuzhipingjia", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateZuZhiPingJias(@PathVariable String branch, @PathVariable String organization,  @RequestBody List<ZuZhiPingJia> zuZhiPingJias) {
    	pingYiService.updateZuZhiPingJias(branch, organization, zuZhiPingJias);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回branch内的所有党员的群众评议信息
    @RequestMapping(value = "/{organization}/{branch}/qunzhongpingyi", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getQunZhongPingYis(@PathVariable String branch, @PathVariable String organization) {
    	List<QunZhongPingYi> qunZhongPingYis = pingYiService.getQunZhongPingYis(branch, organization);
    	return new ResponseEntity<List<QunZhongPingYi>>(qunZhongPingYis, HttpStatus.OK);
    }
    
    //更新branch内的党员的群众评议信息
    @RequestMapping(value = "/{organization}/{branch}/qunzhongpingyi", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateQunZhongPingYis(@PathVariable String branch, @PathVariable String organization,  @RequestBody List<QunZhongPingYi> qunZhongPingYis) {
    	pingYiService.updateQunZhongPingYis(branch, organization, qunZhongPingYis);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    //返回branch内的所有党员的自评信息
    @RequestMapping(value = "/{organization}/{branch}/ziping", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getZiPings(@PathVariable String branch, @PathVariable String organization) {
    	List<ZiPing> ziPings = pingYiService.getZiPings(branch, organization);
    	return new ResponseEntity<List<ZiPing>>(ziPings, HttpStatus.OK);
    }
    
    //更新branch内的党员的自评信息
    @RequestMapping(value = "/{organization}/{branch}/ziping", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> updateZiPings(@PathVariable String branch, @PathVariable String organization,  @RequestBody List<ZiPing> ziPings) {
    	pingYiService.updateZiPings(branch, organization, ziPings);
    	Message m = new Message();
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
}
