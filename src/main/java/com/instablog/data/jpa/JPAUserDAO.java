package com.instablog.data.jpa;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.instablog.api.entity.User;
import com.instablog.api.exception.BloggingException;
import com.instablog.data.UserDAO;

public class JPAUserDAO{} 
//implements UserDAO {
//	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.blogger");
//
//	@Override
//	public void create(User user) {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(user);
//		em.getTransaction().commit();
//		em.close();
//
//	}
//
//	@Override
//	public void delete(String userId) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		System.out.println("JPAUserDAO.delete()");
//		em.getTransaction().begin();
//		User user = em.getReference(User.class,userId);
//		em.remove(user);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	@Override
//	public void update(User blogger) throws BloggingException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public User read(String userLoginId) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		
//		em.getTransaction().begin();
//		User user = em.find(User.class,userLoginId);
//		em.getTransaction().commit();;
//		em.close();
//		return user;
//	}
//
//	@Override
//	public List<User> getAll() throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//        TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL, User.class);
//        List<User> allUsers = query.getResultList();
//        return allUsers;
//	}
//}
