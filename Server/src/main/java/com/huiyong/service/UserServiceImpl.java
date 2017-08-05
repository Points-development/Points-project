/**
 * 
 */
package com.huiyong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiyong.dao.UserMapper;
import com.huiyong.model.User;

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

}
