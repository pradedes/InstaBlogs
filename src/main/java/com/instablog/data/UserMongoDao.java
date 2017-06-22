package com.instablog.data;

import java.util.List;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.QueryResults;

import com.instablog.api.entity.Blog;
import com.instablog.api.entity.User;
import com.instablog.api.exception.AuthorizationFailedException;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.DuplicateUserIdException;
import com.instablog.service.InstaBlogService.InstaBlogPayload;
import com.instablog.util.BloggingConstants;

public class UserMongoDao extends BasicDAO<User, String>implements UserDAO{

	public UserMongoDao(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	@Override
	public void create(User user) throws DuplicateUserIdException, BloggingException {
		System.out.println("UserMongoDao.create()");
		this.save(user);
	}

	@Override
	public void delete(String userid) throws BloggingException {
		this.delete(userid);
	}

	@Override
	public void update(User blogger) throws BloggingException {
		this.update(blogger);
	}

	@Override
	public User read(String userId) throws BloggingException {
		
		QueryResults<User> query = createQuery().field("_id").contains(userId);
		User user= null;
		if(query == null) {
			throw new AuthorizationFailedException();
		} else {
			user =	(User)query.asList().get(0);
		}
		//this.findOne(query)
		return user;
	}

	@Override
	public List<User> getAll() throws BloggingException {
		// TODO Auto-generated method stub
		return null;
	}

}
