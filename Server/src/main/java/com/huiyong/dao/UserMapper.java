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
	void addUser(@Param("user") User user, @Param("propertyId") int propertyId);
	void updateUser(@Param("user") User user, @Param("propertyId") int propertyId);
	Integer getPropertyId(String property);
	List<String> getAllProperties();
	List<String> getAllBranches();
}
