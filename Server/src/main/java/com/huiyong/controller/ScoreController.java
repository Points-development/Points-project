/**
 * 
 */
package com.huiyong.controller;

import java.util.Date;
import java.util.List;

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
import com.huiyong.model.Score;
import com.huiyong.service.ScoreService;
import com.huiyong.service.UserService;

/**
 * @author gangpu
 *
 */
@RestController
@RequestMapping(value = "/score")
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private UserService userService;
	
	//By default will return all the results for the user
	//If scorer is self, will only return self evaluation results
	//If scorer is other, will return all other's score for the user
	//If scorer is a user name A, will return all the scores A did for the user
	//if recent is true, will only return the newest result
    @RequestMapping(value = "/{username}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getScore(@PathVariable String username, @RequestParam(required=false) String scorer, @RequestParam(required=false) Boolean isRecent) {
		List<Score> scores = null;
		Message m = new Message();
		if(null == isRecent){
			isRecent = false;
		}
    	if(null == scorer){
			scores = scoreService.getScoreByUser(username, isRecent);
		}else if("self".equals(scorer)){
			scores = scoreService.getScoreByScorer(username, username, isRecent);
		}else if("other".equals(scorer)){
			scores = scoreService.getScoreByOther(username, isRecent);
		}else{
			scores = scoreService.getScoreByScorer(username, scorer, isRecent);
		}
    	if(null == scores || scores.size() == 0){
    		m.setError("目前没有分数");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<List<Score>>(scores, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public ResponseEntity<String> addScore(@PathVariable String username, @RequestBody Score score) {
    	if(null == score){
        	return new ResponseEntity<String>("Score is null.", HttpStatus.BAD_REQUEST);
    	}
    	if(null == username ){
    		return new ResponseEntity<String>("User name is null.", HttpStatus.BAD_REQUEST);
    	}
    	if(!username.equals(score.getScoree())){
    		return new ResponseEntity<String>("Add score to the user different from username in url.", HttpStatus.BAD_REQUEST);
    	}
    	if(null == userService.getUserByName(username)){
    		return new ResponseEntity<String>("User name does not exist", HttpStatus.BAD_REQUEST);
    	}
    	String scorer = score.getScorer();
    	if(null == scorer || null == userService.getUserByName(scorer)){
    		return new ResponseEntity<String>("Scorer does not exist", HttpStatus.BAD_REQUEST);
    	}
    	score.setLastModifiedTime(new Date());
    	scoreService.addScore(score);
		return new ResponseEntity<String>("Score saved to database.", HttpStatus.OK);
    	
    }
}
