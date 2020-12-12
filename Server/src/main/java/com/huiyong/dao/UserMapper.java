/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.user.User;

/**
 * @author gangpu
 *
 */
public interface UserMapper {
	User getUserByName(@Param("name") String name);
	List<User> getUsersInBranch(@Param("branchname") String branchname, @Param("organization")String organization);
	
	List<User> getUsersInOrganization(@Param("organization")String organization, @Param("realname")String username);
	
	void addUser(@Param("user") User user, @Param("propertyId") int propertyId);
	void updateUser(@Param("user") User user, @Param("propertyId") int propertyId);
	Integer getPropertyId(@Param("name") String property);
	List<String> getAllProperties();
	List<String> getAllBranches(@Param("organization")String organziation);
	void deleteUser(String username);
	void deleteBranch(@Param("branch") String branchname, @Param("organization")String organization);
	void addBranch(@Param("branch") String branchname, @Param("organization")String organization);
	String getBranch(@Param("branch") String branchname, @Param("organization")String organization);
	List<String> getAllOrganizations();
}
