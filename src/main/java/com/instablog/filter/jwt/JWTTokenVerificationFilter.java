package com.instablog.filter.jwt;

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.instablog.api.exception.AuthorizationFailedException;
import com.instablog.util.KeyGenerator;
import com.instablog.util.SimpleKeyGenerator;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;

@Provider
@VerifyJWTToken
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenVerificationFilter implements ContainerRequestFilter {

	KeyGenerator keyGen = new SimpleKeyGenerator();
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("JWTTokenVerificationFilter.filter()");
		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new AuthorizationFailedException("Authorization header must be provided");
		}

		String token = authorizationHeader.substring("Bearer".length()).trim();

		try {
			Key key = keyGen.generateKey();
			Jws jws=Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			System.out.println("JWTTokenVerificationFilter.filter()" + ((DefaultClaims)jws.getBody()).getSubject());
			System.out.println("JWTTokenVerificationFilter.filter() auth passed");
		} catch (Exception e) {
			System.out.println("JWTTokenVerificationFilter.filter() auth failed");
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

		// requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
	}

}
