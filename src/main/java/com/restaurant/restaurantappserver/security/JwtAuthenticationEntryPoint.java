package com.restaurant.restaurantappserver.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.restaurantappserver.exceptions.InvalidLoginResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {

        InvalidLoginResponse invalidLoginResponse = new InvalidLoginResponse();
        String jsonLoginResponse = new ObjectMapper().writeValueAsString(invalidLoginResponse);

        httpServletResponse.setContentType("application/json");
        httpServletResponse.setStatus(401);
        httpServletResponse.getWriter().print(jsonLoginResponse);



    }
}
