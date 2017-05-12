package com.instablog.api.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Blog {

	@Id
	private int blogId;
	
	private String blogTitle;
	
	private String blogBody;
	
	private int noOfviews;
	
	private Date blogCreatedDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User blogger;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	private List<String> blogHashTags;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogBody() {
		return blogBody;
	}

	public void setBlogBody(String blogBody) {
		this.blogBody = blogBody;
	}

	public int getNoOfviews() {
		return noOfviews;
	}

	public void setNoOfviews(int noOfviews) {
		this.noOfviews = noOfviews;
	}

	public Date getBlogCreatedDate() {
		return blogCreatedDate;
	}

	public void setBlogCreatedDate(Date blogCreatedDate) {
		this.blogCreatedDate = blogCreatedDate;
	}

	public User getBlogger() {
		return blogger;
	}

	public void setBlogger(User blogger) {
		this.blogger = blogger;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<String> getBlogHashTags() {
		return blogHashTags;
	}

	public void setBlogHashTags(List<String> hashTags) {
		this.blogHashTags = hashTags;
	}
	
}
