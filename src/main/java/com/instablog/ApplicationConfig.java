package com.instablog;

import org.glassfish.jersey.server.ResourceConfig;

import com.instablog.filter.jwt.JWTTokenVerificationFilter;

public class ApplicationConfig extends ResourceConfig{
    public ApplicationConfig(){
        super();
        packages("com.instablog.filter.jwt");
//        //register any custom features
        register(JWTTokenVerificationFilter.class);  
     }
}


