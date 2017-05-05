package com.instablog.data;

import com.instablog.api.entity.User;
import com.instablog.api.exception.AuthorizationFailedException;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.DuplicateUserIdException;
import com.instablog.api.exception.NoUserIdFoundException;

public interface UserDAO {

	
	public void create(User user) throws DuplicateUserIdException, BloggingException;
	
	public void delete(String userid) throws BloggingException;
	
	public void update(User blogger) throws BloggingException;
	
	public User read(String userId) throws BloggingException;
	
	

}
