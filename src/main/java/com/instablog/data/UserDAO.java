package com.instablog.data;

import java.util.List;

import com.instablog.api.entity.User;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.DuplicateUserIdException;

public interface UserDAO {

	
	public void create(User user) throws DuplicateUserIdException, BloggingException;
	
	public void delete(String userid) throws BloggingException;
	
	public void update(User blogger) throws BloggingException;
	
	public User read(String userId) throws BloggingException;
	
	public List<User> getAll() throws BloggingException;

}
