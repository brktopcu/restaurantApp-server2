package com.restaurant.restaurantappserver.services;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {
    public HttpHeaders getHeaders(){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin","*");
        responseHeaders.set("Access-Control-Allow-Credentials","true");
        responseHeaders.set("Content-Type","application/json");

        return responseHeaders;
    }
}
