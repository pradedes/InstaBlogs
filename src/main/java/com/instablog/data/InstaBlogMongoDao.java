package com.instablog.data;

import java.util.List;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.instablog.api.entity.Blog;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.NoBlogFoundException;
import com.instablog.service.InstaBlogService.InstaBlogPayload;
import com.instablog.util.BloggingConstants;

public class InstaBlogMongoDao extends BasicDAO<Blog, Integer> implements BlogDAO {

	private Datastore dataStore;

	public InstaBlogMongoDao(Class<Blog> entityClass, Datastore ds) {
		super(entityClass, ds);
		dataStore = ds;
	}

	@Override
	public void create(Blog b) throws BloggingException {
		this.save(b);
	}

	@Override
	public void delete(int blogid) throws BloggingException {
		this.delete(blogid);

	}

	@Override
	public void update(Blog b) throws BloggingException {
		this.update(b);
	}

	@Override
	public List<Blog> read(Object payload) throws NoBlogFoundException, BloggingException {
		
		String queryType = ((InstaBlogPayload)payload).getQueryType();
		 QueryResults<Blog> query =null;
		
		 if(queryType.equals(BloggingConstants.FIND_BY_BLOGGERCONTENT)){
				String queryString = ((InstaBlogPayload)payload).getSearchString();
				
				Document doc = new Document("blogTitle", queryString);
				 query  = createQuery().field("blogTitle").contains(queryString);
				
		}else if(queryType.equals(BloggingConstants.FIND_ALL)){
			
			
			 query  = this.find();
					 }
		 if(query == null){
			 throw new BloggingException();
		 }
		return query.asList();
	}

	

}
