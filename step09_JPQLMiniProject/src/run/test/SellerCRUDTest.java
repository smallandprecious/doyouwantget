package run.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Seller;
import util.PublicCommon;

public class SellerCRUDTest {
	
	//판매자가 상품 가격 업데이트
	@Test
	public void updateSeller() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Seller seller = em.find(Seller.class, "yoons1234");
			if(seller != null) {
				//before update
				System.out.println("update 전 : " + seller);
				seller.setResell_price(410000);
			}else {
				System.out.println("업데이트 할 수 있는 상품이 없습니다.");
			}
			tx.commit();
			//after update
			System.out.println("update 후 : " + seller);
		}catch (Exception e) {
		e.printStackTrace();
	}finally {
		em.close();
	}
}
	
	//상품이 팔린 후 해당 상품 삭제
	@Test
	public void deleteSeller() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Seller seller = em.find(Seller.class, "yoons1234");
			if(seller != null) {
				em.remove(seller);
			}else {
				System.out.println("삭제하려는 상품이 존재하지 않습니다.");
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	

}
