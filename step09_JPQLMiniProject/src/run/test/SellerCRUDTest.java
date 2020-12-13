package run.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.domain.Seller;
import util.PublicCommon;

public class SellerCRUDTest {

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
	

}
