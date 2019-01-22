package com.prs.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.prs.db.DBUtil;

public class VendorDB {
	public static Vendor getVendorById(int vendorID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Vendor vendor = em.find(Vendor.class, vendorID);
			return vendor;
		}
		finally {
			em.close();
			
		}
	}
	
	public static List<Vendor> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Vendor> vendors = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT v FROM Vendor v");
			vendors = q.getResultList();
		}
		finally {
			em.close();
		}
		return vendors;
	}
	
	public static boolean insert(Vendor vendor) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(vendor);
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
	
	public static boolean delete(Vendor vendor) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			vendor = em.find(Vendor.class, vendor.getId());
			em.remove(vendor);
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
	
	public static boolean update(Vendor vendor) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(vendor);
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
