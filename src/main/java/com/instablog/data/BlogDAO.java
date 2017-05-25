
package com.instablog.data;

import java.util.List;

import com.instablog.api.entity.Blog;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.NoBlogFoundException;
import com.instablog.service.InstaBlogService.InstaBlogPayload;

public interface BlogDAO {
	
	public void create(Blog b) throws BloggingException;
	
	public void delete(int blogid) throws BloggingException;
	
	public void update(Blog b) throws BloggingException;
	
//	public List<Blog> read(int blogId, int bloggerId,String hashTag, String content) throws NoBlogFoundException, BloggingException;

	public List<Blog> read(Object payload) throws NoBlogFoundException, BloggingException;


}
