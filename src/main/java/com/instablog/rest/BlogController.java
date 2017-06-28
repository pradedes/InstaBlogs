package com.instablog.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instablog.api.entity.Blog;
import com.instablog.filter.jwt.VerifyJWTToken;
import com.instablog.service.BlogService;
import com.instablog.service.InstaBlogService;
import com.instablog.util.BloggingConstants;

@Path("blog")
public class BlogController {
	
	private static BlogService blogService = new InstaBlogService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@VerifyJWTToken
	public Response createBlog(Blog blog){
		System.out.println("BlogController.createBlog() Blog: "+ blog.getBlogBody()+" blogtitle : "+ blog.getBlogTitle());
		blogService.postBlog(blog);
		return Response.ok().build();
	}
	
	@PUT//patch 
	@Consumes(MediaType.APPLICATION_JSON)
	//@VerifyJWTToken
	public Response editBlog(Blog blog){
		blogService.editBlog(blog);
		return Response.ok().build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	//@VerifyJWTToken
	@Path("/{blogId}")
	public Response deleteBlog(@PathParam("blogId")int blogId){
		blogService.deleteBlog(blogId);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{blogId}")
	public Response viewBlog(@PathParam("blogId") int blogId){
		List<Blog> blogs = blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_ID,blogId, null);
		Blog blog;
		if(blogs.isEmpty()){
			System.out.println("BlogController.viewBlog() *********************");
			return Response.ok("No blogs found").status(Response.Status.NO_CONTENT).build();
		}
		blog = blogs.get(0);
		System.out.println("BlogController.viewBlog() blog: "+ blog);
		return Response.ok().entity(blog).build();
	}

	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchInContentQ(@QueryParam("searchStr") String searchStr){
		System.out.println("BlogController.searchInContentQ()");
		System.out.println("searchStr" +  searchStr);
		GenericEntity<List<Blog>> entity = null;
		if(searchStr != null){
			System.out.println("BlogController.searchInContentQ()");
			List<Blog> blog = (List<Blog>)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_CONTENT, -1, searchStr);
			System.out.println("BlogController.searchInContentQ()");
			entity = new GenericEntity<List<Blog>>(blog) {};
		} else {
			List<Blog> blog = blogService.searchBlog(BloggingConstants.SEARCH_ALL_BLOGS, -1, null);
			if(blog.isEmpty()){
				System.out.println("BlogController.viewBlog() *********************");
				return Response.noContent().build();
			
			}
			System.out.println("BlogController.getAllBlogs() ******");
			entity = new GenericEntity<List<Blog>>(blog) {};
		}

		return Response.ok().entity(entity).build();
	}

//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAllBlogs(){
//		List<Blog> blog = blogService.searchBlog(BloggingConstants.SEARCH_ALL_BLOGS, -1, null);
//		if(blog.isEmpty()){
//			System.out.println("BlogController.viewBlog() *********************");
//			return Response.noContent().build();
//		
//		}
//		System.out.println("BlogController.getAllBlogs() ******");
//		GenericEntity<List<Blog>> entity = new GenericEntity<List<Blog>>(blog) {};
//		return Response.ok().entity(entity).build();
//	}
//	
	/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blogger")
	public Response searchByBlogger(@QueryParam("blogger") int blogger){
		List<Blog> blogs = blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOGGER,blogger, null);
		if(blogs.isEmpty()){
			return Response.ok("No blogs found").build();
		}
		GenericEntity<List<Blog>> entity = new GenericEntity<List<Blog>>(blogs) {};
		//List building logic;
		return Response.ok().entity(entity).build();
	}
	*/
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByHashtag(@PathParam("hashtag") String hashtag){
		Blog blog = (Blog)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_HASHTAG,hashtag).get(0);
		//List building logic;
		return Response.ok().entity(blog).build();
	}*/

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchBlog?{searchStr}")
	public Response searchInContent(@QueryParam("searchStr") String searchStr){
		List<Blog> blog = (List<Blog>)blogService.searchBlog(BloggingConstants.SEARCH_BY_BLOG_HASHTAG, -1, searchStr);
		GenericEntity<List<Blog>> entity = new GenericEntity<List<Blog>>(blog) {};
		return Response.ok().entity(blog).build();
	}*/

}
