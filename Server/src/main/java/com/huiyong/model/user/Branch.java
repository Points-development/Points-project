/**
 * 
 */
package com.huiyong.model.user;

import java.util.List;

/**
 * @author gangpu
 *
 */
public class Branch {
	String branchName;
	List<User> users;
	public String getbranchName() {
		return branchName;
	}
	public void setbranchName(String name) {
		this.branchName = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
