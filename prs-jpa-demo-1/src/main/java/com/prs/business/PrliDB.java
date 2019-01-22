package com.prs.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.prs.db.DBUtil;

public class PrliDB {
	public static PurchaseRequestLineItem getPrilById(int prliID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			PurchaseRequestLineItem prli = em.find(PurchaseRequestLineItem.class, prliID);
			
			return prli;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}

	public static List<PurchaseRequestLineItem> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequestLineItem> prs = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT pr FROM PurchaseRequestLineItem pr");
			prs = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return prs;
	}
	
	public static boolean insert(PurchaseRequestLineItem prli) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(prli);
			trans.commit();
			recalculateTotal(em,prli);
			success = true;
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}  finally {
			em.close();
		}
		
		return success;
	}
	
	public static boolean delete(PurchaseRequestLineItem prli) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			prli = em.find(PurchaseRequestLineItem.class, prli.getId());
			em.remove(prli);
			trans.commit();
			recalculateTotal(em,prli);
			success = true;
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return success;
	}
	
	public static boolean update(PurchaseRequestLineItem prli) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(prli);
			trans.commit();
			recalculateTotal(em,prli);
			success = true;
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return success;
	}
	
	private static void recalculateTotal(EntityManager em, PurchaseRequestLineItem prli) {
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		PurchaseRequest request = prli.getRequest();
		Product p = prli.getProduct();
		double oldTotal = request.getTotal();
		double price = p.getPrice();
		int quantity = prli.getQuantity();
		double newTotal = oldTotal + price * quantity;
		
		request.setTotal(newTotal);
		em.merge(request);
		trans.commit();
	}
}