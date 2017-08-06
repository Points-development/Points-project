/**
 * 
 */
package com.huiyong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huiyong.dao.UserMapper;
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
	 * @see com.huiyong.service.UserService#addUser(com.huiyong.model.User)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addUser(User user) {
		userDao.addUser(user);
	}

}
