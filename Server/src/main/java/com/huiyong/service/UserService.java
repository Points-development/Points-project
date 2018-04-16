/**
 * 
 */
package com.huiyong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.user.Branch;
import com.huiyong.model.user.User;

/**
 * @author gangpu
 *
 */
public interface UserService {
	public User getUserByName(String name);
	public List<User> getUsersInBranch(@Param("branchname") String branchname, String organziation);
	public Integer getPropertyId(@Param("property")String property);
	public void addUser(@Param("user")User user, @Param("property_id")int propertyID);
	public void updateUser(@Param("user")User user, @Param("property_id")int propertyID);
	public List<Branch> getAllUsers(String organziation);
	public List<String> getAllProperties();
	public void deleteUser(String username);
	public List<String> getAllBranches(String organziation);
	public void deleteBranch(String branchname, String organziation);
	public void addBranch(String branchname, String organziation);
}
