/**
 * 
 */
package com.huiyong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.User;

/**
 * @author gangpu
 *
 */
public interface UserService {
	public User getUserByName(String name);
	public List<User> getUsersInBranch(@Param("branchname") String branchname);
	public void addUser(User user);
	public void updateUser(User user);
}
