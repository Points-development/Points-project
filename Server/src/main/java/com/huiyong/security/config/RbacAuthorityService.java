package com.huiyong.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.huiyong.model.user.RestUserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Component("rbacauthorityservice")
public class RbacAuthorityService {
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object userInfo = authentication.getPrincipal();

        boolean hasPermission  = false;

        if (userInfo instanceof UserDetails) {
            //获取资源
            Set<String> urls = new HashSet<String>();
            urls.add(request.getContextPath() + "/ws/userservice/*"); 

            AntPathMatcher antPathMatcher = new AntPathMatcher();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                	if(((UserDetails) userInfo).getAuthorities().contains(new SimpleGrantedAuthority(RestUserDetails.ROLE_ORGANIZATION_ADMIN))) {
                        hasPermission = true;
                        break;
                	}
                }else {
                	//for all other urls need not admin ROLE
                	hasPermission = true;
                }
            }
            return hasPermission;
        } else {
            return false;
        }
    }
}
