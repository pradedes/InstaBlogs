package com.instablog.service;

import com.instablog.api.entity.Comment;
import com.instablog.api.exception.BloggingException;

public interface CommentService {
	
	public void postComment(Comment c) throws BloggingException;
	
	public void deleteBlog(int commentid) throws BloggingException;
	
	public void editBlog(Comment c) throws BloggingException;

}
