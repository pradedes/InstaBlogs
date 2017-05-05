package com.instablog.data;

import com.instablog.api.entity.Comment;
import com.instablog.api.exception.BloggingException;

public interface CommentDAO {
	
	public void create(Comment c) throws BloggingException;
	
	public void delete(int commentid) throws BloggingException;
	
	public void update(Comment c) throws BloggingException;
	
	//public Comment read(int commentId) throws BloggingException;
}
