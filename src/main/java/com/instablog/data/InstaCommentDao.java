package com.instablog.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.instablog.api.entity.Blog;
import com.instablog.api.entity.Comment;
import com.instablog.api.exception.BloggingException;

public class InstaCommentDao {}
//implements CommentDAO {
//	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.blogger");
//
//	@Override
//	public void create(Comment c) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(c);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	@Override
//	public void delete(int commentid) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		Comment comment = em.find(Comment.class, commentid);
//		System.out.println("InstaBlogDao.delete()"+ comment+" bogid : "+ commentid);
//		if(comment != null)
//			em.remove(comment);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	@Override
//	public void update(Comment c) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		Comment comment = em.find(Comment.class, c.getCommentId());
//		if(comment != null)
//			em.merge(c);
//		em.getTransaction().commit();
//		em.close();
//
//	}
//
//}
