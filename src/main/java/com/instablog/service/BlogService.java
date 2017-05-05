package com.instablog.service;

import java.util.List;

import com.instablog.api.entity.Blog;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.NoBlogFoundException;

public interface BlogService {
	public void postBlog(Blog b) throws BloggingException;

	public void deleteBlog(int blogid) throws BloggingException;

	public void editBlog(Blog b) throws BloggingException;

	public List<Blog> searchBlog(int searcType,String searchStr)
	 throws NoBlogFoundException, BloggingException;

}

