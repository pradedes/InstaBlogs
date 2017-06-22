package com.instablog.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.instablog.api.entity.Blog;
import com.instablog.api.exception.BloggingException;
import com.instablog.api.exception.NoBlogFoundException;
import com.instablog.service.InstaBlogService.InstaBlogPayload;
import com.instablog.util.BloggingConstants;

public class InstaBlogDao {//implements BlogDAO {
//	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.blogger");
//
//	@Override
//	public void create(Blog b) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(b);
//		em.getTransaction().commit();
//		em.close();
//
//	}
//
//	@Override
//	public void delete(int blogid) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		Blog blog = em.find(Blog.class, blogid);
//		System.out.println("InstaBlogDao.delete()" + blog + " bogid : " + blogid);
//		if (blog != null)
//			em.remove(blog);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	@Override
//	public void update(Blog b) throws BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		Blog blog = em.find(Blog.class, b.getBlogId());
//		if (blog != null)
//			em.merge(b);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	@Override
//	public List<Blog> read(Object payload) throws NoBlogFoundException, BloggingException {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		
//		
//		String queryType = ((InstaBlogPayload)payload).getQueryType();
//		
//
//		TypedQuery<Blog> query = em.createNamedQuery(queryType, Blog.class);
//		if(queryType.equals(BloggingConstants.FIND_BY_BLOGGERID)){
//			System.out.println("InstaBlogDao.read()" + ((InstaBlogPayload)payload).getBloggerId());
//			query.setParameter("bloggerId", ((InstaBlogPayload)payload).getBloggerId());
//		}else if(queryType.equals(BloggingConstants.FIND_BY_BLOGID)){
//			query.setParameter("blogId", ((InstaBlogPayload)payload).getBlogId());
//		}else if(queryType.equals(BloggingConstants.FIND_BY_BLOGGERCONTENT)){
//			//query.setParameter("searchString", ((InstaBlogPayload)payload).getSearchString());
//			query.setParameter("searchString", "%" +  ((InstaBlogPayload)payload).getSearchString() + "%");
//		}
//		
//
//		System.out.println("InstaBlogDao.read() " + query);
//		List<Blog> blogs = query.getResultList();
//		System.out.println("InstaBlogDao.read() blogs: " + blogs);
//		System.out.println("InstaBlogDao.read() size " + blogs.size());
//		em.getTransaction().commit();
//		em.close();
//		return blogs;
//	}
//
//	/*
//	 * public List<Blog> readAll(int blogId, int bloggerId, String hashTag,
//	 * String content) throws NoBlogFoundException, BloggingException {
//	 * List<Blog> blogs= new ArrayList<Blog>(); EntityManager em =
//	 * factory.createEntityManager(); em.getTransaction().begin(); Blog blog =
//	 * null; if(blogId == -1 && bloggerId == -1){ TypedQuery<Blog> query =
//	 * em.createNamedQuery(Blog.FIND_ALL, Blog.class);
//	 * System.out.println("InstaBlogDao.read() " + query); blogs =
//	 * query.getResultList(); }else if(bloggerId == -1 && blogId != -1){ blog =
//	 * em.find(Blog.class, blogId); blogs.add(blog); }else if(bloggerId == -1 &&
//	 * blogId != -1){
//	 * 
//	 * } System.out.println("InstaBlogDao.read() blog: "+ blogs);
//	 * em.getTransaction().commit(); em.close(); return blogs; }
//	 */
//	
//
}
