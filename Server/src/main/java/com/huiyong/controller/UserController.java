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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.model.Message;
import com.huiyong.model.user.Branch;
import com.huiyong.model.user.User;
import com.huiyong.service.UserService;
import com.huiyong.util.MD5Util;



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
    	Message m = new Message();
    	if(null==user || null == user.getName() || null ==user.getPassword()){
    		m.setError("用户名和密码必须提供");
    		return new ResponseEntity<Message>(m, HttpStatus.FORBIDDEN);
    	}
    	User userFromDB = userService.getUserByName(user.getName());
    	if(null == userFromDB){
    		m.setError("用户不存在");
    		return new ResponseEntity<Message>(m, HttpStatus.FORBIDDEN);
    	}
    	String passwordMD5 = MD5Util.getPwd(user.getPassword());
    	if(null == passwordMD5){
    		m.setError("密码不正确");
        	return new ResponseEntity<Message>(m, HttpStatus.FORBIDDEN);
    	}
    	if(passwordMD5.equals(userFromDB.getPassword())){
        	return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    	}
    	m.setError("密码不正确");
    	return new ResponseEntity<Message>(m, HttpStatus.FORBIDDEN);
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
    //Return users in the same branches with the required user
    @RequestMapping(value = "/branch", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getUsersByBranch(@RequestParam String branch) {
    	Message m = new Message();
    	if(null == branch){
    		m.setError("支部不能为空");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	List<User> users = userService.getUsersInBranch(branch);
    	return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
    	Message m = new Message();
    	if(null==user.getName() || null == user.getRealName()){
    		m.setError("用户名不能为空.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	User userFromDB = userService.getUserByName(user.getName());
    	if(null != userFromDB){
    		m.setError("用户已经存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	if(null == user.getPassword()){
    		user.setPassword("123456");
    	}
    	if(null == user.getBranch()|| "".equals( user.getBranch())){
    		user.setBranch("NULL");
    	}
    	Integer propertyId = userService.getPropertyId(user.getProperty());
    	if(null == propertyId){
    		m.setError("用户身份不能为空.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	user.setPassword(MD5Util.getPwd(user.getPassword()));
    	userService.addUser(user, propertyId);
    	m.setSuccess("创建成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    @RequestMapping(value = "/user/{username}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user) {
    	Message m = new Message();
    	if(null==user.getName() || username == null || null == user.getRealName()){
    		m.setError("用户名不能为空.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	if(!username.equals(user.getName())){
    		m.setError("用户名和请求名不一致.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	User userFromDB = userService.getUserByName(username);
    	if(null == userFromDB){
    		m.setError("用户不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	if(null == user.getBranch()|| "".equals( user.getBranch())){
    		user.setBranch("NULL");
    	}
    	Integer propertyId = userService.getPropertyId(user.getProperty());
    	if(null == propertyId){
    		m.setError("用户身份不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	if(null != user.getPassword()){
    		user.setPassword(MD5Util.getPwd(user.getPassword()));
    	}
    	
    	userService.updateUser(user, propertyId);
    	m.setSuccess("更新成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Branch> getUsers() {
    	return userService.getAllUsers();
    }
    @RequestMapping(value = "/user/property", method = RequestMethod.GET)
    public List<String> getProperties() {
    	return userService.getAllProperties();
    }
    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
    	Message m = new Message();
    	User userFromDB = userService.getUserByName(username);
    	if(null == userFromDB){
    		m.setError("用户不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	userService.deleteUser(username);
    	m.setSuccess("删除成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
}
