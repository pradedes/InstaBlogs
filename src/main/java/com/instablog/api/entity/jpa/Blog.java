package com.instablog.api.entity.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.instablog.util.BloggingConstants;

@Entity
@NamedQueries({ @NamedQuery(name = BloggingConstants.FIND_ALL, query = "SELECT b FROM Blog b") ,
@NamedQuery(name = BloggingConstants.FIND_BY_BLOGID, query = "SELECT b FROM Blog b where b.blogId=:blogId"),
@NamedQuery(name = BloggingConstants.FIND_BY_BLOGGERID, query = "SELECT b FROM Blog b where b.noOfviews=:bloggerId"),
@NamedQuery(name = BloggingConstants.FIND_BY_BLOGGERCONTENT, query = "SELECT b from Blog b where b.blogBody like :searchString")})
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blogId;
	
	
	
	private String blogTitle;
	
	@Column(length=5000)
	private String blogBody;
	
	
	private String noOfviews;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date blogCreatedDate;
	
	@ManyToOne
	private User user;
	
/*	 @ElementCollection(targetClass=String.class)
	private List<String> blogHashTags;*/

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
