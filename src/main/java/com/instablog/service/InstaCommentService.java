package com.instablog.service;

import com.instablog.api.entity.Comment;
import com.instablog.api.exception.BloggingException;
import com.instablog.data.CommentDAO;
import com.instablog.data.InstaCommentDao;

public class InstaCommentService implements CommentService {
	
	CommentDAO commentDao = null;//new InstaCommentDao();

	@Override
	public void postComment(Comment c) throws BloggingException {
		commentDao.create(c);
	}

	@Override
	public void deleteBlog(int commentid) throws BloggingException {
		commentDao.delete(commentid);

	}

	@Override
	public void editBlog(Comment c) throws BloggingException {
		commentDao.update(c);

	}

}
