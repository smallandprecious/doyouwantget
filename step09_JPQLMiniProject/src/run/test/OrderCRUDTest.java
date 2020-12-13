package run.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Product;
import util.PublicCommon;

//BUYER가 사고싶은 상품을 검색을 한다 
//buyer의 사고싶은 상품의 prodid의 prodname이 같은 상품들의 사이즈(또는 정보)를 검색한다..
//product 테이블에서 sellid와 buyid값이 모두 null이 아니라면 구매를 진행한다

public class OrderCRUDTest {
	public void findBuyer(EntityManager em, String prodname) {//prodname으로 product 찾기 
		List<Product> resultList  = em.createNativeQuery("select * from product where prodname = ?", Product.class)
				.setParameter(1, prodname).getResultList();
		resultList.forEach(v->System.out.println(v));
	}
	
//	public void findSize(EntityManager em, int prodid) {//ㅔprodid로 size찾기 
//		List<String> resultList = em.createNativeQuery("select prodsize from product where prodid = ?", Product.class)
//				.setParameter(1, prodid).getResultList();
//		resultList.forEach(v->System.out.println(v));
//	}
//	
//	public void findProd(EntityManager em, int prodid, int buyid) { //ㅔprodid와 buyid로 product찾
//		List<Product> resultList  = em.createNativeQuery("select * from product where buyid is not null and sellid is not null", Product.class)
//				.setParameter(1, prodid).setParameter(2, buyid).getResultList();
//		if(resultList.size() != 0) {
//			System.out.println("구매를 진행합니다");
//		} else {
//			System.out.println("제품이 존재하지 않습니다");
//		}

//	}
	
	//상품 가격 변경
//	public static void updatePrice(EntityManager em, int prodid, int price) {
//		int result = em.createNativeQuery("update product set price = ? where prodid =?", Product.class).setParameter(1, price).setParameter(2,prodid).executeUpdate();
//		if(result !=0) {
//			System.out.println("---업데이트 완료---");
//		}else {
//			System.out.println("---업데이트 실패---");
//		}
//	}

	
	// INSERT
	@Test
	public void createOrder() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();


		try {
			tx.begin();
			findBuyer(em, "Nike Big Swoosh Full Zip Jacket Black Volt");
			
//			findSize(em,230);
//			
//			findProd(em, 1, 1);
//			
//			updatePrice(em,1, 180000); 
//		
			tx.commit();

//			em.flush();
//			em.clear();
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
}
