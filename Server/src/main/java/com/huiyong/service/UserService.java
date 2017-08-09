/**
 * 
 */
package com.huiyong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.Branch;
import com.huiyong.model.User;

/**
 * @author gangpu
 *
 */
public interface UserService {
	public User getUserByName(String name);
	public List<User> getUsersInBranch(@Param("branchname") String branchname);
	public Integer getPropertyId(@Param("property")String property);
	public void addUser(@Param("user")User user, @Param("property_id")int propertyID);
	public void updateUser(@Param("user")User user, @Param("property_id")int propertyID);
	public List<Branch> getAllUsers();
	public List<String> getAllProperties();
	public List<String> getAllBranches();
	public void deleteUser(String username);
}
