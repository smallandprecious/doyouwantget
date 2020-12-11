package run.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Order;
import util.PublicCommon;

public class OrderCRUDTest {
	// INSERT
	/**
	 * INSERT 후에는 반드시 "persistence.xml"의 
	 * <property name="hibernate.hbm2ddl.auto" value="create" /> 부분을
	 * <property name="hibernate.hbm2ddl.auto" value="none" />로 변경하기!
	 */
	
	/*@Test
	public void createOrder() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			
			
			em.persist(abc);
			tx.commit();

//			em.flush();
//			em.clear();
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}/*
	
	// UPDATE
	/*@Test
	public void updateOrder() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();

			
			
			em.persist(abc);
			tx.commit();

//			em.flush();
//			em.clear();
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}*/
	
	// SELECT
	/*@Test
	public void findOrder() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}*/
	
	// DELETE
	/*@Test
	public void deleteOrder() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();

			
			
			em.remove(abc);
			tx.commit();

//			em.flush();
//			em.clear();
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}*/
}
