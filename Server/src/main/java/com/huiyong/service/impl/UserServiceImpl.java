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
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#updateUser(com.huiyong.model.User, int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateUser(User user, int propertyID) {
		userDao.updateUser(user, propertyID);
		
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
	public List<Branch> getBranchesInOrganization(String organziation) {
		return userDao.getBranchesInOrganization(organziation);
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
	public void deleteBranchInOrganizationByName(String branchname, String organziation) {
		userDao.deleteBranchInOrganizationByName(branchname, organziation);
		
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public boolean addBranchInOrganization( String organziation, Branch branch) {
		if(null != getBranchInOrganizationByName(branch.getName(), organziation)){
			return false;
		}
		userDao.addBranchInOrganization(organziation,  branch);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.huiyong.service.UserService#addBranch(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Branch getBranchInOrganizationByName(String branchname, String organziation) {
		return userDao.getBranchInOrganizationByName( branchname,  organziation);	
	}

	@Override
	public RestUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RestUserDetails rud = userDao.loadUserByUsername(username);

		Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();
		GrantedAuthority authority;
		if(null == rud.getRole()) {
			authority = new SimpleGrantedAuthority("ROLE_USER");
		}else {
			authority = new SimpleGrantedAuthority(rud.getRole());
		}
		authoritiesSet.add(authority);
		rud.setAuthorities(authoritiesSet);

		return rud;
	}

	@Override
	public Integer getOrganizationId(String organziation) {
		return userDao.getOrganizationId(organziation);
	}

	@Override
	public Integer getBranchId(String organziation, String branch) {
		return userDao.getBranchId(organziation, branch);
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
