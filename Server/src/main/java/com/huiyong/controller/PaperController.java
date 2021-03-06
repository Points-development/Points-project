/**
 * 
 */
package com.huiyong.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.model.paper.PaperTest;
import com.huiyong.model.user.User;
import com.huiyong.service.PaperService;
import com.huiyong.service.UserService;

/**
 * @author gangpu
 *
 */
@RestController
@RequestMapping(value = "/ws/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private UserService userService;
	
    //Return users in the same branches with the required user
    @RequestMapping(value = "/{id}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getPaper(@PathVariable int id, @RequestParam(required=false)String username) {
    	PaperTest paper = null;
    	if(null != username){
    		User aUser = userService.getUserByName(username);
    		if(null == aUser){
    			return new ResponseEntity<String>("User does not exist.", HttpStatus.BAD_REQUEST);
    		}
    		paper = paperService.getPaperByIdAndUserProperty(id, aUser.getProperty());
    	}else{
        	paper = paperService.getPaperById(id);   		
    	}
    	if(null == paper){
    		return new ResponseEntity<String>("Paper does not exist.", HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<PaperTest>(paper, HttpStatus.OK);
    }
//    @RequestMapping(value = "/{id}", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
//    public ResponseEntity<?> addPaper(@RequestBody PaperTest pt) {
//
//    }
}
