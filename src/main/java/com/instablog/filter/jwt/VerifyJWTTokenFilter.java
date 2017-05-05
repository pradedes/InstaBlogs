package com.instablog.filter.jwt;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
@VerifyJWTToken
@Priority(Priorities.AUTHENTICATION)
public class VerifyJWTTokenFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		// Get the HTTP Authorization header from the request
		
		// Check if the HTTP Authorization header is present and formatted correctly
		
		// Extract the token from the HTTP Authorization header
		
		// Validate the token
		// requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
	}

}
