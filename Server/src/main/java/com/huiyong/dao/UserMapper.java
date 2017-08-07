/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.User;

/**
 * @author gangpu
 *
 */
public interface UserMapper {
	User getUserByName(@Param("name") String name);
	List<User> getUsersInBranch(@Param("branchname") String branchname);
	void addUser(User user);
	void updateUser(User user);
}
