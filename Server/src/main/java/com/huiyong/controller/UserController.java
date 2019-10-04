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
import com.huiyong.model.user.Branch;
import com.huiyong.model.user.Organization;
import com.huiyong.model.user.RestUserDetails;
import com.huiyong.model.user.User;
import com.huiyong.security.util.JwtTokenUtil;
import com.huiyong.service.UserService;
import com.huiyong.util.MD5Util;



/**
 * @author gangpu
 *
 */
@RestController
@RequestMapping(value = "/ws")
public class UserController {
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/login", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) {
    	Message m = new Message();
    	if(null==user || null == user.getName() || null ==user.getPassword()){
    		m.setError("用户名和密码必须提供");
    		return new ResponseEntity<Message>(m, HttpStatus.FORBIDDEN);
    	}
    	RestUserDetails userFromDB = userService.loadUserByUsername(user.getName());
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
    		String jwtToken = JwtTokenUtil.generateToken(user.getName(), 3000, "_secret");
    		m.setSuccess("Login successfully");
    		m.setJwtToken(jwtToken);
    		m.setResult(userFromDB);
        	return new ResponseEntity<Message>(m, HttpStatus.OK);
    	}
    	m.setError("密码不正确");
    	return new ResponseEntity<Message>(m, HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/userservice/user/property", method = RequestMethod.GET)
    public List<String> getUserProperties() {
    	return userService.getAllProperties();
    }

    @RequestMapping(value = "/userservice/organizations", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getOrganizations() {
    	List<Organization> organizations = userService.getOrganizations();
    	if(null == organizations) {
    		Message m = new Message();
    		m.setError("组织不存在");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<List<Organization>>(organizations, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/organizations", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> addOrganization(@RequestBody Organization organization) {
    	Message m = new Message();
    	Integer organizationId = userService.getOrganizationId(organization.getName());
    	if(null != organizationId){
    		m.setError("该组织已存在");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	userService.addOrganization(organization);
    	m.setSuccess("添加成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/{organization}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getOrganization(@PathVariable String organization) {
    	Organization aOrganization = userService.getOrganization(organization);
    	if(null == aOrganization) {
    		Message m = new Message();
    		m.setError("组织不存在");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Organization>(aOrganization, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/{organization}", produces = "application/json; charset=UTF-8", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrganization(@PathVariable String organization) {
    	Message m = new Message();
    	Organization aOrganization = userService.getOrganization(organization);
    	if(null == aOrganization){
    		m.setError("组织不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	List<Branch> branches = userService.getBranchesInOrganization(organization);
    	if(null!=branches && !branches.isEmpty()){
    		m.setError("组织内存在支部,不能删除");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	userService.deleteOrganization(organization);
    	m.setSuccess("删除成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
 
    //得到该组织内的所有branch的列表
    @RequestMapping(value = "/userservice/{organization}/branches", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getBranchesInOrganization(@PathVariable String organization) {
    	List<Branch> branches = userService.getBranchesInOrganization(organization);
    	if(null == branches) {
    		Message m = new Message();
    		m.setError("组织不存在");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<List<Branch>>(branches, HttpStatus.OK);
    }
    
    //添加一个新的branch
    @RequestMapping(value = "/userservice/{organization}/branches", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> addBranchInOrganization(@PathVariable String organization, @RequestBody Branch branch) {
    	Message m = new Message();
    	Integer organizationId = userService.getOrganizationId(organization);
    	if(null == organizationId){
    		m.setError("该组织不存在");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	branch.setOrganizationId(organizationId);
    	if(!userService.addBranchInOrganization(organization, branch)){
    		m.setError("支部已经存在");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	m.setSuccess("添加成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/{organization}/{branch}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getBranchesInOrganizationByName(@PathVariable String organization, @PathVariable String branch) {
    	Branch abranch = userService.getBranchInOrganizationByName(organization, branch);
    	if(null == abranch) {
    		Message m = new Message();
    		m.setError("支部不存在");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Branch>(abranch, HttpStatus.OK);
    }
    //删除branch，同时会删除所有属于该branch的user
    @RequestMapping(value = "/userservice/{organization}/{branch}", produces = "application/json; charset=UTF-8", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBranchInOrganizationByName( @PathVariable String organization, @PathVariable String branch) {
    	Message m = new Message();
    	List<User> users = userService.getUsersInBranch(branch, organization);
    	if(null!=users && !users.isEmpty()){
    		m.setError("支部内存在用户,不能删除");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	userService.deleteBranchInOrganizationByName(branch, organization);
    	m.setSuccess("删除成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/userservice/{organization}/{branch}/users", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getUsersInBranch(@PathVariable String organization, @PathVariable String branch) {
    	Message m = new Message();
    	if(null == branch || null == organization){
    		m.setError("支部和组织不能为空");
    		return new ResponseEntity<Message>(m, HttpStatus.NOT_FOUND);
    	}
    	List<User> users = userService.getUsersInBranch(branch, organization);
    	return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/{organization}/{branch}/users", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
    public ResponseEntity<?> addUserInBranch(@PathVariable String organization, @PathVariable String branch, @RequestBody User user) {
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
    	if(null == userService.getOrganizationId(organization)){
    		m.setError("组织不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	Integer branchId=userService.getBranchId(organization, branch);
    	if(null == branchId){
    		m.setError("支部不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	user.setBranchId(branchId);
    	Integer propertyId = userService.getPropertyId(user.getProperty());
    	if(null == propertyId){
    		m.setError("用户身份不能为空.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	if(null!=user.getPassword()) {
        	user.setPassword(MD5Util.getPwd(user.getPassword()));
    	}
    	userService.addUser(user, propertyId);

    	m.setSuccess("创建成功.");
    	return new ResponseEntity<Message>(m, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/{organization}/{branch}/{username}", produces = "application/json; charset=UTF-8", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable String organization, @PathVariable String branch, @PathVariable String username, @RequestBody User user) {
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
    	if(null == userService.getOrganizationId(organization)){
    		m.setError("组织不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	Integer branchId=userService.getBranchId(organization, branch);
    	if(null == branchId){
    		m.setError("支部不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	user.setBranchId(branchId);
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
    @RequestMapping(value = "/userservice/{organization}/{branch}/{user}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByName(@PathVariable("user") String username) {
    	Message m = new Message();
    	User userFromDB = userService.getUserByName(username);
    	if(null == userFromDB){
    		m.setError("用户不存在.");
    		return new ResponseEntity<Message>(m, HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    }
    @RequestMapping(value = "/userservice/{organization}/{branch}/{user}", produces = "application/json; charset=UTF-8", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserByName(@PathVariable("user") String username) {
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
