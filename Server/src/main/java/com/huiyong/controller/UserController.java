/**
 * 
 */
package com.huiyong.controller;

import com.huiyong.model.User;
import com.huiyong.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author gangpu
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) {
    	//TODO now just verify the password and return valid/invalid, later need return JWT token
    	User userFromDB = userService.getUserByName(user.getName());
    	if(null == userFromDB){
    		return new ResponseEntity<String>("User does not exist.", HttpStatus.FORBIDDEN);
    	}
    	if(user.getPassword().equals(userFromDB.getPassword())){
        	return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>("password is not correct.", HttpStatus.FORBIDDEN);
    }
    //Return users in the same branches with the required user, except the user itself
    @RequestMapping(value = "/branch/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(@RequestParam String username) {
    	User userFromDB = userService.getUserByName(user.getName());
    	if(null == userFromDB){
    		return new ResponseEntity<String>("User does not exist.", HttpStatus.FORBIDDEN);
    	}
    	if(user.getPassword().equals(userFromDB.getPassword())){
        	return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>("password is not correct.", HttpStatus.FORBIDDEN);
    }
}
