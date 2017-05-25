package com.instablog.rest;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.instablog.api.entity.User;
import com.instablog.filter.jwt.VerifyJWTToken;
import com.instablog.service.UserService;
import com.instablog.service.UserServiceImpl;
import com.instablog.util.KeyGenerator;
import com.instablog.util.SimpleKeyGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("user")
public class UserController {

	static UserService service = new UserServiceImpl();

	private KeyGenerator keyGen=new SimpleKeyGenerator();
	
	@Context
    private UriInfo uriInfo;

	
	@POST
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public Response signup(User user) {
		System.out.println("UserController.signup 11w44()");
		service.signup(user);
		//User signedUser=service.viewProfile(user.getUserLoginId());
		String token = Jwts.builder()
                .setSubject(user.getUserLoginId())
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, keyGen.generateKey())
                .compact();
		// Return the token on the response
		//User user=service.viewProfile(loginId);
		return Response.ok().header(AUTHORIZATION, "Bearer " + token).entity(user).build();
	}

	@PUT // patch
	@Consumes(APPLICATION_JSON)
	@VerifyJWTToken
	public Response editProfile(User user) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{userId}")
	@Consumes(APPLICATION_JSON)
	@VerifyJWTToken
	public Response deleteProfile(@PathParam("userId") String userId) {
		System.out.println("UserController.deleteProfile jjjj()");
		service.deleteAccount(userId);;
		return Response.ok().build();
	}

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response viewProfile(@PathParam("userId") String userId) {
		System.out.println("UserController.viewProfilesafa()");
		User user=service.viewProfile(userId);
		return Response.ok().entity(user).build();
	}
	
	@GET
	@Path("?")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewProfileWithQP(@QueryParam("userName") String userName) {
		System.out.println("UserController.viewProfileWithQP()");
		//User user=service.viewProfile(userId);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(@QueryParam("userName") String userName,@QueryParam("userEmail") String email) {
		System.out.println("UserController.viewProfilesafa with generic()" + userName);
		System.out.println("UserController.getAllUsers() " + email);
		List<User> all=service.getAll();
		if(all!=null){
			System.out.println("UserController.getAllUsers() " + all.size());
		} else {
			System.out.println("UserController.getAllUsers() list is empty");
		}
		
		GenericEntity<List<User>> entity = new GenericEntity<List<User>>(all) {};
		return Response.ok(entity).build();
	}

	@GET
	@Path("/resttest")
	@Produces(MediaType.TEXT_PLAIN)
	public String resttest() {
		System.out.println("UserController.resttest()");
		return "Rest Test";
	}

	@POST
	@Path("/login")
	@Consumes(APPLICATION_FORM_URLENCODED)
	@Produces(APPLICATION_JSON)
	public Response authenticateUser(@FormParam("loginId") String loginId, @FormParam("password") String password) {
		try {
			System.out.println("UserController.authenticateUser() " + loginId + " " + password);
			// Authenticate the user using the credentials provided
			service.authenticate(loginId, password);
			// Issue a token for the user
			
			
			String token = Jwts.builder()
		                .setSubject(loginId)
		                .setIssuer(uriInfo.getAbsolutePath().toString())
		                .setIssuedAt(new Date())
		                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
		                .signWith(SignatureAlgorithm.HS512, keyGen.generateKey())
		                .compact();
			// Return the token on the response
			User user=service.viewProfile(loginId);
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).entity(user).build();
			//return "Successfully Login";
		} catch (Exception e) {
			//return "Invalid Auth Info";
			return Response.status(UNAUTHORIZED).build();
		}
	}
	
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
	
//	@POST
//	@Path("/login")
//	
//	@Consumes(APPLICATION_JSON)
	//public String authenticateUser(final MultivaluedMap<String, String> formParams) {
//	public Response authenticateUser(User user) {
//	//public Response authenticateUser(@FormParam("loginId") String loginId, @FormParam("password") String password) {
//		try {
//			System.out.println("UserController.authenticateUser() ");// + loginId + " " + password);
//			// Authenticate the user using the credentials provided
//			//service.authenticate(loginId, password);
//			// Issue a token for the user
//			String token = "";
//			// Return the token on the response
//			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
//
//		} catch (Exception e) {
//			return Response.status(UNAUTHORIZED).build();
//		}
//	}
}
