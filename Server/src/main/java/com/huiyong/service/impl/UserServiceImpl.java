/**
 * 
 */
package com.huiyong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huiyong.dao.UserMapper;
import com.huiyong.model.user.Branch;
import com.huiyong.model.user.User;
import com.huiyong.service.UserService;

/**
 * @author gangpu
 *
 */
@Service
public class UserServiceImpl implements UserService {;
	@Autowired
	private UserMapper userDao;

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getUsersInBranch(java.lang.String)
	 */
	@Override
	public List<User> getUsersInBranch(String branchname, String organization) {
		return userDao.getUsersInBranch(branchname, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getPropertyId(java.lang.String)
	 */
	@Override
	public Integer getPropertyId(String property) {
		return userDao.getPropertyId(property);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addUser(com.huiyong.model.User, int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addUser(User user, int propertyID) {
		userDao.addUser(user, propertyID);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#updateUser(com.huiyong.model.User, int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateUser(User user, int propertyID) {
		userDao.updateUser(user, propertyID);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getAllUsers()
	 */
	@Override
	public List<Branch> getAllUsersInBranch(String organziation) {
		List<String> bList = userDao.getAllBranches(organziation);
		List<Branch> buList = new ArrayList<Branch>();
		for(String branch: bList){
			List<User> uList = userDao.getUsersInBranch(branch, organziation);
			Branch aBranch = new Branch();
			aBranch.setbranchName(branch);
			aBranch.setUsers(uList);
			buList.add(aBranch);
		}
		return buList;
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getAllProperties()
	 */
	@Override
	public List<String> getAllProperties() {
		return userDao.getAllProperties();
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getAllBranches()
	 */
	@Override
	public List<String> getAllBranches(String organziation) {
		return userDao.getAllBranches(organziation);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#deleteUser(java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#deleteBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void deleteBranch(String branchname, String organziation) {
		userDao.deleteBranch(branchname, organziation);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public boolean addBranch(String branchname, String organziation) {
		if(null != getBranch(branchname, organziation)){
			return false;
		}
		userDao.addBranch( branchname,  organziation);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public String getBranch(String branchname, String organziation) {
		return userDao.getBranch( branchname,  organziation);	
	}

	@Override
	public List<User> getUsersInOrganziation(String organiziation, String username) {
		return userDao.getUsersInOrganization(organiziation, username);
	}

}
