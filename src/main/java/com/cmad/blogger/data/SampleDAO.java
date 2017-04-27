package com.cmad.blogger.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cmad.blogger.api.User;

public class SampleDAO {
	private EntityManagerFactory factory= Persistence.createEntityManagerFactory("com.blogger");
	
	public User read(int userId){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class,userId);
		em.getTransaction().commit();;
		em.close();
		return user;
	}
	
	public void create(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();;
		em.close();
	
	}
}