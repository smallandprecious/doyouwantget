# Resell Project

---------------

## Do you want to get?

---------------

> 안녕하세요!
>> **작소모** 팀(작고 소중한 모임)
>>> **이민재, 장문희, 조윤혜, 최지수** 입니다.

--------------

### 프로젝트 계획 이유

저희 **작소모(작고 소중한 모임)조**에서는 **'Resell'** 이라는 참신한 주제를 선정해 프로젝트를 진행해 보기로 결정하였습니다. 구매한 신제품이나 여러 종류들의 물품들을 되팔아 시세차익을 확보하는 소비 방식인 'Resell' 은 전통적으로 명품 브랜드 중심으로 형성되었지만, 최근에는 희소가치가 있는 상품 등 많은 품목들이 도입되고 있습니다. 특히 최근 떠오르고 있는 스니커즈 리셀은 **'스니커테크(스니커즈 + 재테크)'** 라는 신조어가 나올 정도로 어마어마한 글로벌 트렌드로 자리잡고 있습니다. 

저희는 이 프로젝트를 진행하며, 최근 등장한 **'크림'** 이라는 애플리케이션을 참고하여 구매자와 판매자가 원하는 기준이 같으면 판매가 가능할 수 있도록 하는 시스템을 구현해 보았습니다.

아래 자료는 현 시점, 전세계 밀레니얼 및 Z세대를 중심으로 커지고 있는 스니커즈 리셀 시장의 규모를 나타내는 자료입니다.

-------------

#### - Resell 관련 - 전세계 스니커즈 리셀 시장 규모

<div>
    <img width="800" src="https://user-images.githubusercontent.com/73863771/102001950-f43d7d00-3d3a-11eb-9d51-95bc2f9aaea3.png">
</div>

--------------

### Resell Project 기능 설명

--------------
#### Modeling 


<div>
    <img width="800" src="https://user-images.githubusercontent.com/73386460/102009493-17881c80-3d7b-11eb-9519-f9fe447b0689.PNG">
</div>

--------------

#### [Buyer, 구매자 기능]

-------------

1. 

2.

3. 

--------------

#### [Seller, 판매자 기능]

1. 

2. 

3. 

----------------

### Buyer CRUD 구현 과정

```




```

---------------

### Seller CRUD 구현 과정

```
package run.test;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
//import javax.persistence.Query;

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
			System.out.println("#== | SELLER_ID | SELLER_ADDRESS | SELLER_NAME | SELLER_PHONE_NUMBER | ==#");
			System.out.println("판매자 ID : " + sel1.getSellid() + " | "
								+ sel1.getSeladdress() + " | "
								+ sel1.getSelname() + " 님" + " | "
								+ "휴대전화번호 : " + sel1.getSelphonum());
			
			// >_ #== | SELLER_NAME | SELLER_PRODUCT_SIZE | RESELL_PRICE | ==#
			// 판매자 ID : Test1234 | 검증용 님 | 휴대전화번호 : 010-7777-7777
			
			sel1.setSelphonum("010-9999-9999");
			tx.commit();
						
			// sel1 - After UPDATE
			System.out.println("\n### After UPDATE ###");
			System.out.println("#== | SELLER_ID | SELLER_ADDRESS | SELLER_NAME | SELLER_PHONE_NUMBER | ==#");
			System.out.println("판매자 ID : " + sel1.getSellid() + " | "
								+ sel1.getSeladdress() + " | "
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

```

-------------

### Order CRUD 구현 과정

```



```

------------

