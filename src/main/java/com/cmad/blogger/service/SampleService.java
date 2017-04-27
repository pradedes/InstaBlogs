package com.cmad.blogger.service;

import com.cmad.blogger.api.User;
import com.cmad.blogger.data.SampleDAO;

public class SampleService {
	SampleDAO dao = new SampleDAO();
	
	
	public User find(int userId) {
			User user = dao.read(userId);
			return user;
	}
	
	public void add(User user) {
		{
			if (user == null){
				throw new RuntimeException();
			}
			dao.create(user);
		}
	}
}
