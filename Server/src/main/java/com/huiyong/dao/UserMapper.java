/**
 * 
 */
package com.huiyong.dao;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.User;

/**
 * @author gangpu
 *
 */
public interface UserMapper {
	User getUserByName(@Param("name") String name);
}
