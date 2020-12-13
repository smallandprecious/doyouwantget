package run.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Seller;
import util.PublicCommon;

public class SellerCRUDTest {
	
	// $$$ 참고만 해주세요!!! $$$
	// $$$ 테이블 날아갑니다!!! $$$
	
	// CREATE
	/**
	 * CREATE 후에는 반드시 "persistence.xml"의 
	 * <property name="hibernate.hbm2ddl.auto" value="create" /> 부분을
	 * <property name="hibernate.hbm2ddl.auto" value="none" />로 변경하기!
	 */
//	@Test
	public void createSeller() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			System.out.println("\n### Create Seller ###");
			Seller sel1 = Seller.builder().sellid("Test1234")
										  .selname("검증용")
										  .selphonum("010-7777-7777")
										  .seladdress("검증용 주소입니다").build();
			em.persist(sel1);
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
	
	// $$$ 참고만 해주세요!!! $$$
	// $$$ 테이블 날아갑니다!!! $$$
	
	/**
	 * ### Seller Table ###
	 * create table seller (
     * seller_id varchar2(20) not null,
     * product_size number(10,0),
     * resell_price number(10,0),
     * seller_address varchar2(255),
     * seller_name varchar2(10),
     * seller_phone varchar2(20),
     * product_id number(10,0),
     * primary key (seller_id)
     * )
     * 
     * insert into Seller (
     * 		product_id, product_size, resell_price,
     * 		seller_address, seller_name, seller_phone, seller_id
     * ) values (?, ?, ?, ?, ?, ?, ?)
     * 
     * >_ 출력 결과
     * 
     * ### Find Seller ###
     * SELLER_ID SELLER_NAME SELLER_ADDRESS    SELLER_PHONE
	 * --------- ----------- ----------------- -------------
	 * Test1234  검증용      검증용 주소입니다 010-7777-7777
	 */
	
	// SELECT
//	@Test
	public void findSeller() {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			// 검증용 님의 ID(Test1234)로 해당 판매자의 모든 정보 조회
			Seller sel1 = em.find(Seller.class, "Test1234");
			if(sel1 != null) {
				System.out.println("\n### Find Seller ###");
				System.out.println("# SELLER_ID : " + sel1.getSellid());
				System.out.println("# SELLER_NAME : " + sel1.getSelname());
				System.out.println("# SELLER_PHONE_NUM : " + sel1.getSelphonum());
				System.out.println("# SELLER_ADDRESS : " + sel1.getSeladdress());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	/**
	 * select seller0_.seller_id as seller_i1_3_0_,
	 * 		  seller0_.product_id as product_7_3_0_,
	 * 		  seller0_.product_size as product_2_3_0_,
	 * 		  seller0_.resell_price as resell_p3_3_0_,
	 * 		  seller0_.seller_address as seller_a4_3_0_,
	 * 		  seller0_.seller_name as seller_n5_3_0_,
	 * 		  seller0_.seller_phone as seller_p6_3_0_
	 * from seller seller0_
	 * where seller0_.seller_id=?
	 * 
	 * >_ 출력 결과
	 * ### Find Seller ###
	 * # SELLER_id : Test1234
	 * # SELLER_NAME : 검증용
	 * # SELLER_PHONE_NUM : 010-7777-7777
	 * # SELLER_ADDRESS : 검증용 주소입니다
	 */
	
	
	// UPDATE
//	@Test
	public void updateSeller() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			// 검증용 님의 ID(Test1234)로 휴대번호(selphonum) 변경(UPDATE)
			Seller sel1 = em.find(Seller.class, "Test1234");
						
			// sel1 - Before UPDATE
			System.out.println("\n### Before UPDATE ###");
			System.out.println("#== | SELLER_ID | SELLER_NAME | SELLER_PHONE_NUMBER | ==#");
			System.out.println("판매자 ID : " + sel1.getSeladdress() + " | "
								+ sel1.getSelname() + " 님" + " | "
								+ "휴대전화번호 : " + sel1.getSelphonum());
			
			// >_ #== | SELLER_NAME | SELLER_PRODUCT_SIZE | RESELL_PRICE | ==#
			// 판매자 ID : Test1234 | 검증용 님 | 휴대전화번호 : 010-7777-7777
			
			sel1.setSelphonum("010-9999-9999");
			tx.commit();
						
			// sel1 - After UPDATE
			System.out.println("\n### After UPDATE ###");
			System.out.println("#== | SELLER_ID | SELLER_NAME | SELLER_PHONE_NUMBER | ==#");
			System.out.println("판매자 ID : " + sel1.getSeladdress() + " | "
								+ sel1.getSelname() + " 님" + " | "
								+ "휴대전화번호 : " + sel1.getSelphonum());
			// >_ #== | SELLER_NAME | SELLER_PRODUCT_SIZE | RESELL_PRICE | ==#
			// 판매자 ID : Test1234 | 검증용 님 | 휴대전화번호 : 010-9999-9999

//			em.flush();
//			em.clear();
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	// DELETE
//	@Test
	public void deleteSeller() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Seller sel1 = em.find(Seller.class, "Test1234");
			if(sel1 != null) {
				System.out.println("\n### 해당 판매자의 거래가 완료되었습니다 ###");
				em.remove(sel1);
				tx.commit();
				
//				em.flush();
//				em.clear();
		} else {
			System.out.println("\n### 삭제에 실패하였습니다. 올바른 ID 값을 입력해 주세요 ###");
		}
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
}
