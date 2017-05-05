package com.instablog.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instablog.api.entity.Comment;
import com.instablog.filter.jwt.VerifyJWTToken;

@Path("/comment")
public class CommentController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response postComment(Comment comment) {
		return Response.ok().build();
	}

	@PUT // patch
	@Consumes(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response editComment(Comment comment) {
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response deleteComment(@PathParam("commentid") int commentId) {
		return Response.ok().build();
	}

}