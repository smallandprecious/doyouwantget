package run.test;

import java.util.ArrayList;
import java.util.List;

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

	//create
	public static void addBuyer(String buyid, String buyname, String buyphonum, String buyaddress, EntityManager em)  {
		Buyer b = Buyer.builder().buyid(buyid).buyname(buyname).buyphonum(buyphonum).buyaddress(buyaddress).build();
		em.persist(b);
	}
	//select

	public static void findAll(EntityManager em)  {
		List<Buyer> b = em.createNativeQuery("select * from Buyer", Buyer.class).getResultList();
		b.forEach(v-> System.out.println(v));
	}

	public static void findBuyerId(int buyid , EntityManager em)  {
		List<Buyer> b = em.createNativeQuery("select * from Buyer where buyid= ?", Buyer.class).setParameter(1, buyid)
				.getResultList();
		b.forEach(v-> System.out.println(v));
	}

	public static void findBuyerName(String buyname , EntityManager em)  {
		List<Buyer> b = em.createNativeQuery("select * from Buyer where buyid= ?", Buyer.class).setParameter(1, buyname)
				.getResultList();
		b.forEach(v-> System.out.println(v));
	}



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


