/**
 * 
 */
package com.huiyong.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huiyong.dao.UserMapper;
import com.huiyong.model.user.Branch;
import com.huiyong.model.user.Organization;
import com.huiyong.model.user.RestUserDetails;
import com.huiyong.model.user.User;
import com.huiyong.service.UserService;

/**
 * @author gangpu
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {;
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
	public List<User> getUsersInBranch(String branchname, String organization) {
		return userDao.getUsersInBranch(branchname, organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getPropertyId(java.lang.String)
	 */
	@Override
	public Integer getPropertyId(String property) {
		return userDao.getPropertyId(property);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addUser(com.huiyong.model.User, int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addUser(User user, int propertyID) {
		userDao.addUser(user, propertyID);
		String role = user.getRole();
		if(null != role ) {
			if(role.equals(RestUserDetails.ROLE_BRANCH_ADMIN)  || role.equals(RestUserDetails.ROLE_ORGANIZATION_ADMIN) ) {
				userDao.assignRoleToUser(user.getId(),userDao.getRoleId(role));
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#updateUser(com.huiyong.model.User, int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateUser(User user, int propertyID) {
		userDao.updateUser(user, propertyID);
		String role = user.getRole();
		if(null != role ) {
			if(role.equals(RestUserDetails.ROLE_BRANCH_ADMIN)  || role.equals(RestUserDetails.ROLE_ORGANIZATION_ADMIN) ) {
				userDao.assignRoleToUser(user.getId(),userDao.getRoleId(role));
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getAllProperties()
	 */
	@Override
	public List<String> getAllProperties() {
		return userDao.getAllProperties();
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#getAllBranches()
	 */
	@Override
	public List<Branch> getBranchesInOrganization(String organization) {
		return userDao.getBranchesInOrganization(organization);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#deleteUser(java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#deleteBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void deleteBranchInOrganizationByName(String branchname, String organization) {
		userDao.deleteBranchInOrganizationByName(branchname, organization);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public boolean addBranchInOrganization( String organization, Branch branch) {
		if(null != getBranchInOrganizationByName(branch.getName(), organization)){
			return false;
		}
		userDao.addBranchInOrganization(organization,  branch);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Branch getBranchInOrganizationByName(String branchname, String organization) {
		return userDao.getBranchInOrganizationByName( branchname,  organization);	
	}

	@Override
	public RestUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RestUserDetails rud = userDao.loadUserByUsername(username);
		if(null == rud) {
			return null;
		}
		Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();
		GrantedAuthority authority;
		if(null == rud.getRole()) {
			authority = new SimpleGrantedAuthority(RestUserDetails.ROLE_USER);
		}else {
			authority = new SimpleGrantedAuthority(rud.getRole());
		}
		authoritiesSet.add(authority);
		rud.setAuthorities(authoritiesSet);

		return rud;
	}

	@Override
	public Integer getOrganizationId(String organization) {
		return userDao.getOrganizationId(organization);
	}

	@Override
	public Integer getBranchId(String organization, String branch) {
		return userDao.getBranchId(organization, branch);
	}

	@Override
	public List<Organization> getOrganizations() {
		return userDao.getOrganizations();
	}

	@Override
	public void addOrganization(Organization organization) {
		userDao.addOrganization(organization);
		
	}

	@Override
	public Organization getOrganization(String organization) {
		return userDao.getOrganization(organization);
	}

	@Override
	public void deleteOrganization(String organization) {
		userDao.deleteOrganization(organization);
		
	}

}
