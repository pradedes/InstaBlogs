package com.cmad.blogger.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cmad.blogger.api.User;
import com.cmad.blogger.service.SampleService;

@Path("/sample")
public class SampleController {
	public static SampleService service = new SampleService();

	@GET
	@Path("/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("userId") int userId) {
		System.out.println("SampleController.find()");
		User user = service.find(userId);
		if(user==null){
			System.out.println("User is null");
		}
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("/user/resttest")
	@Produces(MediaType.TEXT_PLAIN)
	public String resttest() {
		System.out.println("SampleController.resttest()");
		return "Rest Test";
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(User user) {
		System.out.println("SampleController.add()");
		service.add(user);
		return Response.ok().build();
	}
}