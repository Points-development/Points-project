/**
 * 
 */
package com.huiyong;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.util.AntPathMatcher;

import com.huiyong.model.pingyi.CategoryInfo;
import com.huiyong.model.pingyi.CategoryPoint;
import com.huiyong.model.pingyi.ZuZhiPingJia;

/**
 * @author gangpu
 *
 */
public class TempTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        AntPathMatcher antPathMatcher = new AntPathMatcher();

        if (antPathMatcher.match("/ws/paper/**", "/ws/paper/1")) {
        	System.out.println("matched");
        }
	}

}
