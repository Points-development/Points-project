package com.huiyong.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huiyong.model.Message;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e)
			throws IOException, ServletException {
		Message responseBody = new Message();

        responseBody.setError("Need Authorities!");
        
        httpServletResponse.setStatus(401);

        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
		
	}
}
