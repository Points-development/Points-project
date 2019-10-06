/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.user.Branch;
import com.huiyong.model.user.Organization;
import com.huiyong.model.user.RestUserDetails;
import com.huiyong.model.user.User;

/**
 * @author gangpu
 *
 */
public interface UserMapper {
	User getUserByName(@Param("name") String name);
	RestUserDetails loadUserByUsername(@Param("name") String name);
	Integer getPropertyId(@Param("name") String property);
	Integer getOrganizationId(@Param("organization")String organization);
	Integer getBranchId(@Param("organization")String organization, @Param("branch")String branch);
	List<String> getAllProperties();
	
	List<User> getUsersInBranch(@Param("branchname") String branchname, @Param("organization")String organization);
	void addUser(@Param("user") User user, @Param("propertyId") int propertyId);
	void updateUser(@Param("user") User user, @Param("propertyId") int propertyId);
	void deleteUser(String username);
	
	List<Branch> getBranchesInOrganization(@Param("organization")String organization);
	void deleteBranchInOrganizationByName(@Param("branch") String branchname, @Param("organization")String organization);
	void addBranchInOrganization( @Param("organization")String organization, @Param("branch") Branch branch );
	Branch getBranchInOrganizationByName(@Param("branch") String branch, @Param("organization")String organization);
	
	List<Organization> getOrganizations();
	void addOrganization(@Param("organization") Organization organization);
	void deleteOrganization(@Param("organization") String organization);
	Organization getOrganization(@Param("organization") String organization);
	Integer getRoleId(@Param("role") String role);
	void assignRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
	
}
