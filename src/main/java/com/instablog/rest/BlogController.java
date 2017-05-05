package com.instablog.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instablog.api.entity.Blog;
import com.instablog.filter.jwt.VerifyJWTToken;
import com.instablog.service.BlogService;
import com.instablog.util.BloggingConstants;

@Path("/blog")
public class BlogController {
	
	private BlogService blogService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response createBlog(Blog blog){
		return Response.ok().build();
	}
	
	@PUT//patch 
	@Consumes(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response editBlog(Blog blog){
		return Response.ok().build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@VerifyJWTToken
	public Response deleteBlog(@PathParam("blogId") String blogId){
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewBlog(@PathParam("blogId") String blogId){
		Blog blog = (Blog)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_ID,blogId).get(0);
		
		return Response.ok().entity(blog).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByBlogger(@PathParam("blogger") String blogger){
		Blog blog = (Blog)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOGGER,blogger).get(0);
		//List building logic;
		return Response.ok().entity(blog).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByHashtag(@PathParam("hashtag") String hashtag){
		Blog blog = (Blog)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_HASHTAG,hashtag).get(0);
		//List building logic;
		return Response.ok().entity(blog).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchInContent(@PathParam("searchStr") String searchStr){
		Blog blog = (Blog)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_HASHTAG,searchStr).get(0);
		//List building logic;
		return Response.ok().entity(blog).build();
	}
	
}
