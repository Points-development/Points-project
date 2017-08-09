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
import com.huiyong.model.Branch;
import com.huiyong.model.User;
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
	public List<User> getUsersInBranch(String branchname) {
		return userDao.getUsersInBranch(branchname);
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
	public List<Branch> getAllUsers() {
		List<String> bList = userDao.getAllBranches();
		List<Branch> buList = new ArrayList<Branch>();
		for(String branch: bList){
			List<User> uList = userDao.getUsersInBranch(branch);
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
	public List<String> getAllBranches() {
		return userDao.getAllBranches();
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

}
