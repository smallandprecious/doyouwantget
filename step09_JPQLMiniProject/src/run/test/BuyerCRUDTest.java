package run.test;

import javax.persistence.EntityManager;\
import javax.persistence.EntityTransaction;

import model.domain.Buyer;
import model.domain.Seller;
import util.PublicCommon;

public class BuyerCRUDTest {
	
//	public void createBuyer() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
			
//			Buyer buyer1 = Buyer.builder().buyer_id("ok1231").product_id(em.find(Product.class, 2)).buy_name("권오민").buy_pho_num("010-1234-2345").buy_address("인천광역시 연수구 송도동").buy_size(270).hope_price(400000).build();
//			Buyer buyer2 = Buyer.builder().buyer_id("rabbit777").product_id(em.find(Product.class, 4)).buy_name("권희성").buy_pho_num("010-1234-2346").buy_address("경기도 부천시 소사구 옥길동").buy_size(230).hope_price(200000).build();
//			Buyer buyer3 = Buyer.builder().buyer_id("wonder486").product_id(em.find(Product.class, 8)).buy_name("김민건").buy_pho_num("010-1234-2347").buy_address("인천광역시 남동구 구월1동").buy_size(230).hope_price(1000000).build();
//			Buyer buyer4 = Buyer.builder().buyer_id("ilovecats2").product_id(em.find(Product.class, 7)).buy_name("김성호").buy_pho_num("010-1234-2348").buy_address("경기도 시흥시 정왕3동").buy_size(260).hope_price(120000).build();
//			Buyer buyer5 = Buyer.builder().buyer_id("gajagib98").product_id(em.find(Product.class, 7)).buy_name("조윤혜").buy_pho_num("010-1234-2349").buy_address("경기도 안산시 단원구 고잔동").buy_size(265).hope_price(135000).build();
//			Buyer buyer6 = Buyer.builder().buyer_id("imangel1234").product_id(em.find(Product.class, 19)).buy_name("김재웅").buy_pho_num("010-1234-2350").buy_address("경기도 안산시 상록구 본오3동").buy_size(265).hope_price(590000).build();
//			Buyer buyer7 = Buyer.builder().buyer_id("basketballs2").product_id(em.find(Product.class, 22)).buy_name("김준형").buy_pho_num("010-1234-2351").buy_address("강원도 철원군 김화읍").buy_size(230).hope_price(2800000).build();
//			Buyer buyer8 = Buyer.builder().buyer_id("waterisbest234").product_id(em.find(Product.class, 1)).buy_name("김창훈").buy_pho_num("010-1234-2352").buy_address("경기도 안양시 동안구 달안동").buy_size(250).hope_price(100000).build();
//			Buyer buyer9 = Buyer.builder().buyer_id("loveletter").product_id(em.find(Product.class, 7)).buy_name("양호준").buy_pho_num("010-1234-2353").buy_address("경기도 분당구 백현동").buy_size(280).hope_price(70000).build();
//			
//			em.persist(buyer1);
//			em.persist(buyer2);
//			em.persist(buyer3);
//			em.persist(buyer4);
//			em.persist(buyer5);
//			em.persist(buyer6);
//			em.persist(buyer7);
//			em.persist(buyer8);
//			em.persist(buyer9);
			
//			tx.commit();
//
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//	}
	
	// select
	public void findsize() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Buyer buyer = em.find(Seller.class, 2);
			if(buyer != null) {
				System.out.println("product_id = " + Seller.getproduct_id()+ "\n" + "product_size = " + Seller.getproduct_size());
			}else {
				System.out.println("검색하신 상품의 사이즈 목록이 없습니다");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
 
	
	
	
}



