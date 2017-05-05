package com.instablog.api.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	@Id
	private int commentId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User blogger;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Blog blogId;
	
	private String commentDetails;
	
	private Date commentedDate;
	
	private int parentCommentId;
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public User getBlogger() {
		return blogger;
	}

	public void setBlogger(User blogger) {
		this.blogger = blogger;
	}

	public Blog getBlogId() {
		return blogId;
	}

	public void setBlogId(Blog blogId) {
		this.blogId = blogId;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	public Date getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}

	public int getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(int parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	

}
