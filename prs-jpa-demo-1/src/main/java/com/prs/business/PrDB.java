package com.prs.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.prs.db.DBUtil;

public class PrDB {
	public static PurchaseRequest getPrById(int purchaseRequestID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			PurchaseRequest pr = em.find(PurchaseRequest.class, purchaseRequestID);
			
			return pr;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}

	public static List<PurchaseRequest> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequest> prs = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT pr FROM PurchaseRequest pr");
			prs = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return prs;
	}
	
	public static boolean insert(PurchaseRequest pr) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(pr);
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
	
	public static boolean delete(PurchaseRequest pr) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			pr = em.find(PurchaseRequest.class, pr.getId());
			em.remove(pr);
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
	
	public static boolean update(PurchaseRequest pr) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(pr);
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