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
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.model.PaperTest;
import com.huiyong.service.PaperService;

/**
 * @author gangpu
 *
 */
@RestController
@RequestMapping(value = "/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	
    //Return users in the same branches with the required user
    @RequestMapping(value = "/{id}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getPaper(@PathVariable int id) {
    	PaperTest paper = paperService.getPaperById(id);
    	if(null == paper){
    		return new ResponseEntity<String>("Paper does not exist.", HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<PaperTest>(paper, HttpStatus.OK);
    }

}
