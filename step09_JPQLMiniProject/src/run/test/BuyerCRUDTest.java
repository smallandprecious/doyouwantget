package run.test;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Test;

import model.domain.Buyer;
import model.domain.Seller;
import model.domain.Product;
import util.PublicCommon;

public class BuyerCRUDTest {
	

	
	/*
	 * 	public static void findEmployeebyId(EntityManager em, int eid) {
		Employee employee = em.find(Employee.class, eid);

		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("해당 id의 직원은 미존재합니다");
		}
	}
	 */
	// 구매자가 원하는 상품 검색 후, 해당상품 판매자 보기
	
//	public static void findProdSize(EntityManager em, String prodname) {
//		Product product = em.find(entityClass, primaryKey)
//		String jpql = "select p.size from Product p where p.prodname='Nike Big Swoosh Full Zip Jacket Black Volt'";
//		
//	}
//	
//	@Test
//	public void findsize() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			Buyer buyer = em.find(Buyer.class, "waterisbest234");
////			Product product = em.createQuery("select p.sellers from Product p where p.product_id="+1);
//			Seller seller = em.find(Seller.class, primaryKey)
//			
//			if(buyer != null) {
//				System.out.println("buyer_id = " + buyer.getBuyer_id() + "\n" + "product_id = " + );
//			}else {
//				System.out.println("검색하신 상품의 사이즈 목록이 없습니다");
//			}
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//	}
	// 구매자가 원하는 상품 변경
//	@Test
//	public void updateBuyerProduct() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {		
//			tx.begin();
//			Buyer buyer1 = em.find(Buyer.class, "ok1231");
//			Product productid = buyer1.getProducts();
//		
//			if(buyer1 != null) {
//				//before update
//				System.out.println("업데이트 전 : " + buyer1);
//				buyer1.setprodid(7);
//			}else {
//				System.out.println("업데이트 할 상품이 없습니다.");
//			}tx.commit();
//			//after update
//			System.out.println("업데이트 후 : " + buyer1);
//		}catch (Exception e) {
//		e.printStackTrace();
//	}finally {
//		em.close();
//	}
//		}
	//구매자 id로 해당 구매자 정보 모두 조회
	public void findBuyer() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Buyer buyer = em.find(Buyer.class, "ok1231");
			if(buyer != null) {
				System.out.println("해당 회원의 정보는 다음과 같습니다.");
				System.out.println("해당 회원의 id : " + buyer.getBuyid());
				System.out.println("해당 회원의 성함 : " + buyer.getBuyname());
				System.out.println("해당 회원의 휴대폰번호 : " + buyer.getBuyphonum());
				System.out.println("해당 회원의 주소 : " + buyer.getBuyaddress());
				//System.out.println("해당 회원의 id : " + buyer.getProducts().getprodid());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	// 구매자 이사 후 배송지 변경
	@Test
	public void updateBuyerAddress() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Buyer buyer2 = em.find(Buyer.class, "ok1231");
			if(buyer2 != null) {
				//before update
				System.out.println("업데이트 전 : " + buyer2);
				buyer2.setBuyaddress("서울시 서초구 방배동");
			}else {
				System.out.println("업데이트 할 주소 정보가 없습니다.");
			}tx.commit();
			//after update
			System.out.println("update 후 : " + buyer2);
		}catch (Exception e) {
		e.printStackTrace();
	}finally {
		em.close();
	}
		}
	
	//회원탈퇴
	public void deleteBuyer() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Buyer buyer = em.find(Buyer.class, "ok1231");
			if(buyer != null) {
				em.remove(buyer);
			}else {
				System.out.println("해당 회원은 이미 탈퇴하였습니다.");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	
	
	
	
	
	}
 

