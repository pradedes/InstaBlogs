package com.instablog.service;

import java.util.List;

import com.instablog.api.entity.User;
import com.instablog.api.exception.AuthorizationFailedException;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.DuplicateUserIdException;
import com.instablog.api.exception.NoUserIdFoundException;
import com.instablog.data.UserDAO;
import com.instablog.data.jpa.JPAUserDAO;
import com.instablog.util.PasswordHelper;

public class UserServiceImpl implements UserService {

	UserDAO dao = new JPAUserDAO();

	@Override
	public void authenticate(String userLoginId, String pwd)
			throws NoUserIdFoundException, AuthorizationFailedException, BloggingException {
		User user = dao.read(userLoginId);
		if (user == null) {
			throw new NoUserIdFoundException();
		}
		String passwordHash=PasswordHelper.generateSecurePassword(pwd, user.getSalt());
		System.out.println("Attempted Password Hash " + passwordHash);
		System.out.println("Stored Password Hash " + user.getPassword());
		if(passwordHash.equals(user.getPassword())){
			System.out.println("UserServiceImpl.authenticate() match with case");
		} else if(passwordHash.equalsIgnoreCase(user.getPassword())){
			System.out.println("UserServiceImpl.authenticate() match without case");
		} else{
			throw new AuthorizationFailedException();
		}
	}

	@Override
	public void signup(User user) throws DuplicateUserIdException, BloggingException {
		if (user == null) {
			throw new BloggingException(); // change it to InvalidUserException
		}
		String salt = PasswordHelper.getSalt(30);
		String passwordHash = PasswordHelper.generateSecurePassword(user.getPassword(), salt);

		System.out.println("UserServiceImpl.signup() salt :" + salt);
		System.out.println("UserServiceImpl.signup() passwordHash :" + passwordHash);
		user.setPassword(passwordHash);
		user.setSalt(salt);
		dao.create(user);
	}

	@Override
	public void deleteAccount(String userLoginId) throws BloggingException {
		// TODO Auto-generated method stub
		dao.delete(userLoginId);
	}

	@Override
	public void editProfile(User blogger) throws BloggingException {
		// TODO Auto-generated method stub

	}

	@Override
	public User viewProfile(String UserLoginId) throws BloggingException {
		System.out.println("UserServiceImpl.viewProfile() -->" + UserLoginId);
		User user = dao.read(UserLoginId);
		System.out.println("UserServiceImpl.viewProfile() " + user);
		return user;
	}

	@Override
	public List<User> getAll() throws BloggingException {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
