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
import com.instablog.service.CommentService;
import com.instablog.service.InstaCommentService;

@Path("/comment")
public class CommentController {
	
	private static CommentService commentService = new InstaCommentService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@VerifyJWTToken
	public Response postComment(Comment comment) {
		//System.out.println("CommentController.postComment() comment : " + comment.getBlogger() +" comment.getBloggetId : " + comment.getBlogId());
		commentService.postComment(comment);
		return Response.ok().build();
	}

	@PUT // patch
	@Consumes(MediaType.APPLICATION_JSON)
	//@VerifyJWTToken
	public Response editComment(Comment comment) {
		commentService.editBlog(comment);
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{commentid}")
	//@VerifyJWTToken
	public Response deleteComment(@PathParam("commentid") int commentId) {
		commentService.deleteBlog(commentId);
		return Response.ok().build();
	}

}