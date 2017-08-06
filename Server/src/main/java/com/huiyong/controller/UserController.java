/**
 * 
 */
package com.huiyong.controller;

import com.huiyong.model.User;
import com.huiyong.service.UserService;
import com.huiyong.util.MD5Util;

import java.util.List;

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
	
    @RequestMapping(value = "/login", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) {
    	//TODO now just verify the password and return valid/invalid, later need return JWT token
    	if(null==user || null == user.getName() || null ==user.getPassword()){
    		return new ResponseEntity<String>("User name and password must be provided.", HttpStatus.FORBIDDEN);
    	}
    	User userFromDB = userService.getUserByName(user.getName());
    	if(null == userFromDB){
    		return new ResponseEntity<String>("User does not exist.", HttpStatus.FORBIDDEN);
    	}
    	String passwordMD5 = MD5Util.getPwd(user.getPassword());
    	if(null == passwordMD5){
        	return new ResponseEntity<String>("password is not correct.", HttpStatus.FORBIDDEN);
    	}
    	if(passwordMD5.equals(userFromDB.getPassword())){
        	return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>("password is not correct.", HttpStatus.FORBIDDEN);
    }
    //Return users in the same branches with the required user
    @RequestMapping(value = "/branch/users", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(@RequestParam String username) {
    	User userFromDB = userService.getUserByName(username);
    	if(null == userFromDB){
    		return new ResponseEntity<String>("User does not exist.", HttpStatus.NOT_FOUND);
    	}
    	List<User> users = userService.getUsersInBranch(userFromDB.getBranch());
    	return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
    	if(null==user.getName()){
    		return new ResponseEntity<String>("User name cannot be null.", HttpStatus.BAD_REQUEST);
    	}
    	User userFromDB = userService.getUserByName(user.getName());
    	if(null != userFromDB){
    		return new ResponseEntity<String>("User already exists.", HttpStatus.BAD_REQUEST);
    	}
    	user.setPassword(MD5Util.getPwd(user.getPassword()));
    	userService.addUser(user);
    	return new ResponseEntity<String>("user is added.", HttpStatus.OK);
    }
}
