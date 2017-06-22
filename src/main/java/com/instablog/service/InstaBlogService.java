package com.instablog.service;

import java.util.List;

import org.mongodb.morphia.Datastore;

import com.instablog.api.entity.Blog;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.NoBlogFoundException;
import com.instablog.data.BlogDAO;
import com.instablog.data.InstaBlogMongoDao;
import com.instablog.util.BloggingConstants;
import com.instablog.util.MongoUtil;

public class InstaBlogService implements BlogService {
	
	private static BlogDAO blogDao;


	//BlogDAO blogDao = new InstaBlogDao();
	static{
		Datastore dataStore = MongoUtil.initMongo();
		 blogDao = new InstaBlogMongoDao(Blog.class, dataStore);
	}
	@Override
	public void postBlog(Blog b) throws BloggingException {
		blogDao.create(b);
	}

	@Override
	public void deleteBlog(int blogid) throws BloggingException {
		blogDao.delete(blogid);
	}

	@Override
	public void editBlog(Blog b) throws BloggingException {
		blogDao.update(b);
	}

	@Override
	public List<Blog> searchBlog(int searcType, int searchInt, String searchStr) throws NoBlogFoundException, BloggingException {
		List<Blog> blog = null;
		InstaBlogPayload payload = null;
		switch(searcType){
		case BloggingConstants.SEARCH_BY_BLOG_ID:
			payload = new InstaBlogPayload(BloggingConstants.FIND_BY_BLOGID, searchInt, null, null);
			blog = blogDao.read(payload);
			//System.out.println("InstaBlogService.searchBlog() blog"+ blog.get(0));
			break;
		case BloggingConstants.SEARCH_ALL_BLOGS:
			payload = new InstaBlogPayload(BloggingConstants.FIND_ALL, -1, null, null);
			blog = blogDao.read(payload);
			
		//	System.out.println("InstaBlogService.searchBlog() blog"+ blog.get(0));
			break;
		case BloggingConstants.SEARCH_BY_BLOGGER:
			System.out.println("InstaBlogService.searchBlog() before :" + searchStr);
			payload = new InstaBlogPayload(BloggingConstants.FIND_BY_BLOGGERID, -1, searchStr, null);
			blog = blogDao.read(payload);
		//	System.out.println("InstaBlogService.searchBlog() blog"+ blog.get(0));
			break;
		case BloggingConstants.SEARCH_BY_BLOG_CONTENT:
			payload = new InstaBlogPayload(BloggingConstants.FIND_BY_BLOGGERCONTENT, -1, null, searchStr);
			blog = blogDao.read(payload);
			System.out.println("InstaBlogService.searchBlog() blog"+ blog.get(0));
			break;
		}
		
		return blog;
	}

	
	public class InstaBlogPayload{
		
		private String queryType;
		public String getQueryType() {
			return queryType;
		}

		public void setQueryType(String queryType) {
			this.queryType = queryType;
		}

		public int getBlogId() {
			return blogId;
		}

		public void setBlogId(int blogId) {
			this.blogId = blogId;
		}

		public String getBloggerId() {
			return bloggerId;
		}

		public void setBloggerId(String bloggerId) {
			this.bloggerId = bloggerId;
		}

		public String getSearchString() {
			return searchString;
		}

		public void setSearchString(String searchString) {
			this.searchString = searchString;
		}

		private int blogId;
		private String bloggerId;
		private String searchString;

		public InstaBlogPayload(String queryType, int blogId, String bloggerId, String searchString) {
			this.queryType = queryType;
			this.blogId = blogId;
			this.bloggerId =  bloggerId;
			this.searchString = searchString;
		}
		
	}
}
