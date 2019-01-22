package com.prs.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.prs.db.DBUtil;

public class UserDB {
	public static User getUserById(int userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			User user = em.find(User.class, userID);
			
			return user;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}

	public static List<User> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<User> users = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT u FROM User u");
			users = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return users;
	}
	
	public static boolean insert(User user) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
			success = true;
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}  finally {
			em.close();
		}
		
		return success;
	}
	
	public static boolean delete(User user) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			user = em.find(User.class, user.getId());
			em.remove(user);
			trans.commit();
			success = true;
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return success;
	}
	
	public static boolean update(User user) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
			success = true;
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return success;
	}
}