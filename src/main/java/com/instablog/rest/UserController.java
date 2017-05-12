package com.instablog.rest;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instablog.api.entity.User;
import com.instablog.filter.jwt.VerifyJWTToken;

@Path("/user")
public class UserController {

	@POST
	@Consumes(APPLICATION_JSON)
	@VerifyJWTToken
	public Response signup(User user) {
		return Response.ok().build();	
	}

	@PUT // patch
	@Consumes(APPLICATION_JSON)
	@VerifyJWTToken
	public Response editProfile(User user) {
		return Response.ok().build();
	}

	@DELETE
	@Consumes(APPLICATION_JSON)
	@VerifyJWTToken
	public Response deleteProfile(@PathParam("userId") int userId) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response viewProfile(@PathParam("userId") int userId) {
		return null;
	}

	@POST
	@Path("/login")
	@Consumes(APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("login") String login, 
			@FormParam("password") String password) {
		try {

			// Authenticate the user using the credentials provided

			// Issue a token for the user
			String token = "";
			// Return the token on the response
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
	}
}
