package com.instablog.api.entity;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.instablog.util.BloggingConstants;

@Entity
public class Blog {

	@Id
	private long blogId;
	
	private String blogTitle;
	
	private String blogBody;
	
	
	private String noOfviews;
	
	
	private Date blogCreatedDate;
	
	
	private User user;
	
/*	 @ElementCollection(targetClass=String.class)
	private List<String> blogHashTags;*/

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId2) {
		this.blogId = blogId2;
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

	public String getNoOfviews() {
		return noOfviews;
	}

	public void setNoOfviews(String noOfviews) {
		this.noOfviews = noOfviews;
	}

	public Date getBlogCreatedDate() {
		return blogCreatedDate;
	}

	public void setBlogCreatedDate(Date blogCreatedDate) {
		this.blogCreatedDate = blogCreatedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


/*	public List<String> getBlogHashTags() {
		return blogHashTags;
	}

	public void setBlogHashTags(List<String> hashTags) {
		this.blogHashTags = hashTags;
	}*/
	
}
