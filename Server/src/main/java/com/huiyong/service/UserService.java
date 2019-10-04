/**
 * 
 */
package com.huiyong.service;

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
public interface UserService {
	public RestUserDetails loadUserByUsername(@Param("name") String name);
	public Integer getPropertyId(@Param("property")String property);
	public Integer getOrganizationId(@Param("organziation")String organziation);
	public Integer getBranchId(@Param("organziation")String organziation, @Param("branch")String branch);
	public List<String> getAllProperties();

	public User getUserByName(String name);
	public List<User> getUsersInBranch(@Param("branchname") String branchname, String organziation);
	public void addUser(@Param("user")User user, @Param("property_id")int propertyID);
	public void updateUser(@Param("user")User user, @Param("property_id")int propertyID);
	public void deleteUser(String username);

	public List<Branch> getBranchesInOrganization(String organziation);
	public void deleteBranchInOrganizationByName(String branchname, String organziation);
	public boolean addBranchInOrganization(String organziation, Branch branch);
	public Branch getBranchInOrganizationByName(String branchname, String organziation);
	
	public List<Organization> getOrganizations();
	public void addOrganization(Organization organization);
	public Organization getOrganization(String organization);
	public void deleteOrganization(String organization);
}
