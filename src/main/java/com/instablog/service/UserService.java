package com.instablog.service;

import com.instablog.api.entity.User;
import com.instablog.api.exception.AuthorizationFailedException;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.DuplicateUserIdException;
import com.instablog.api.exception.NoUserIdFoundException;

public interface UserService {
	
	public void login(User blogger) throws NoUserIdFoundException,AuthorizationFailedException, BloggingException;
	
	//we dont have this since we will delete the JWT from client side
	//public void logout(User blogger);
	
	public void signup(User user) throws DuplicateUserIdException, BloggingException;
	
	public void deleteAccount(String userid) throws BloggingException;
	
	public void editProfile(User blogger) throws BloggingException;
	
	public User viewProfile(String userId) throws BloggingException;

}
