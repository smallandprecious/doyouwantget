# Resell Project

---

## Do you want to get?

---

> 안녕하세요!
>> **작소모** 팀(작고 소중한 모임)
>>> **이민재, 장문희, 조윤혜, 최지수** 입니다.

---

### 프로젝트 계획 이유

저희 **작소모(작고 소중한 모임)조**에서는 **'Resell'** 이라는 참신한 주제를 선정해 프로젝트를 진행해 보기로 결정하였습니다. 구매한 신제품이나 여러 종류들의 물품들을 되팔아 시세차익을 확보하는 소비 방식인 'Resell' 은 전통적으로 명품 브랜드 중심으로 형성되었지만, 최근에는 희소가치가 있는 상품 등 많은 품목들이 도입되고 있습니다. 특히 최근 떠오르고 있는 스니커즈 리셀은 **'스니커테크(스니커즈 + 재테크)'** 라는 신조어가 나올 정도로 어마어마한 글로벌 트렌드로 자리잡고 있습니다. 

저희는 이 프로젝트를 진행하며, 최근 등장한 **'크림(KREAM)'** 이라는 애플리케이션을 참고하여 구매자와 판매자가 원하는 기준이 같으면 판매가 가능할 수 있도록 하는 시스템을 구현해 보았습니다.

아래 자료는 현 시점, 전세계 밀레니얼 및 Z세대를 중심으로 커지고 있는 스니커즈 리셀 시장의 규모를 나타내는 자료입니다.

---

#### - Resell 관련 - 전세계 스니커즈 리셀 시장 규모

<div>
    <img width="800" src="https://user-images.githubusercontent.com/73863771/102001950-f43d7d00-3d3a-11eb-9d51-95bc2f9aaea3.png">
</div>

---

## Service 

---

#### [Buyer, 구매자 시나리오]

---

1.  구매자가 원하는 상품 검색 저장하고 리스트를 확인한다.

2.  구매자 이사 후 배송지 변경한다.

3.  구매자 id로 해당 구매자 정보 모두 조회한다.

---

#### [Seller, 판매자 시나리오]

1. 판매자가 자신의 물건이 너무 안팔려서 시세를 알아보기 위해 검색을 한다. 

2. 현 시세에 비해 너무 가격이 높게 측정되어있다는 것을 인지하고 가격을 조정한다.

3. 판매하던 상품이 다시 유행이 되어 소장하기 위해서 판매상품을 삭제한다. 

---

#### [Order, 구매 시나리오]

1. BUYER가 사고싶은 상품명으로 상품을 검색을 한다 

2. BUYER의 사고싶은 상품의 사이즈(또는 정보)를 검색한다.

3. 사고싶은 상품이 나와 사이즈가 맞다면 구매를 진행한다. 

---

## Resell Project 기능 설명

---

### Structure

<div>
    <img width="800" src="https://user-images.githubusercontent.com/17983434/102023939-1cc48600-3dd2-11eb-9907-4f23cdaf3a57.png">
</div>

---

## SQL TABLE

* DDL

```SQL
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE buyer CASCADE CONSTRAINTS;
DROP TABLE seller CASCADE CONSTRAINTS;

CREATE TABLE product (
	prodid	          NUMBER(10)	        PRIMARY KEY,
        buyid             VARCHAR2(20)          NOT NULL,
        sellerid          VARCHAR2(20)          NOT NULL,
	prodname 	  VARCHAR2(255)	        NOT NULL,
	prodsize          NUMBER(3)	        NOT NULL,
	brand	          VARCHAR2(100)	        NOT NULL,
	release_date      VARCHAR2(20)	        NOT NULL,
	price	          NUMBER(10)            NOT NULL,
        resellprice	  NUMBER(10)            NOT NULL
);

CREATE TABLE buyer (
	buyid  	         VARCHAR2(20)		PRIMARY KEY,
	prodid	         NUMBER(10)		NOT NULL,
	buyname	         VARCHAR2(10)		NOT NULL,
	buyphonum	 VARCHAR2(50)		NOT NULL,
	buyaddress	 VARCHAR2(255)		NOT NULL
);

CREATE TABLE seller (
	sellid            VARCHAR2(20)		PRIMARY KEY,
	prodid	          NUMBER(10)		NOT NULL,
	selname	          VARCHAR2(10)		NOT NULL,
	selphonum	  VARCHAR2(50)		NOT NULL,
	seladdress        VARCHAR2(255)		NOT NULL
);

ALTER TABLE buyer ADD CONSTRAINT FK_product_TO_buyer_1 FOREIGN KEY (prodid)
REFERENCES product (prodid);

ALTER TABLE seller ADD CONSTRAINT FK_product_TO_seller_1 FOREIGN KEY (prodid)
REFERENCES product (prodid);
```

* DML

```sql
-- product INSERT
insert into product values (1,'waterisbest234','jordanwant','Nike Big Swoosh Full Zip Jacket Black Volt','230','nike','1999-12-05','129000','160000');
insert into product values (2,'null','null','Jordan 1 x J Balvin Retro High OG','250','jordan','2005-04-15','229000','480000');
insert into product values (3,'null','null','adidas Dame 4 A Bathing Ape Camo','240','adidas','2018-02-17','163200','530000');
insert into product values (4,'rabbit777','null','Nike x Stussy Beach Pant Off Noir','270','stussy','2017-09-22','169000','790000');
insert into product values (5,'null','null','Supreme x Stone Island Painted Camo Nylon 6-Panel Black (20FW)','230','supreme','2020-09-30','71800','890000');
insert into product values (6,'ilovecats2','noniwa','Stussy x Off-White 40 WT Tee','250','stussy','2009-11-03','43500','437000');
insert into product values (7,'loveletter','null','Supreme x Stone Island Painted Camo Crinkle Down Jacket Black (20FW)','260','supreme','2011-02-28','1086400','2790000');
insert into product values (8,'null','ename7535','Nike x PEACEMINUSONE Air Force 1 Low Para-Noise 2.0','240','nike','2020-11-25','219000','250000');
insert into product values (9,'null','null','Supreme x Stone Island Corduroy Jacket Black (20FW)','270','supreme','2020-12-11','716200','600000');
insert into product values (10,'null','null','adidas x LEGO ZX 8000','240','adidas','2008-05-05','169000','200000');
insert into product values (11,'null','null','Nike x kasina Dunk Low 80s Bus','240','nike','2020-09-25','129000','250000');
insert into product values (12,'null','null','Nike x sacai VaporWaffle Royal Fuchsia','260','nike','2020-11-06','219000','380000');
insert into product values (13,'null','null','Jordan 1 Mid Light Smoke Grey','230','jordan','2015-12-01','139000','430000');
insert into product values (14,'null','null','Jordan 5 x Off-White Retro SP Sail Fire Red','250','jordan','2015-08-16','269000','544000');
insert into product values (15,'null','null','Jordan 1 Retro High OG Metallic Gold','250','jordan','2013-04-30','199000','320000');
insert into product values (16,'null','null','Nike x Tom Sachs Mars Yard Shoe 2.0 Space Camp','270','nike','2017-06-09','217500','320000');
insert into product values (17,'gajagib98','null','Nike x Off-White Air Presto OG The Ten','270','nike','2017-09-10','174000','240000');
insert into product values (18,'null','null','adidas Yeezy Boost 350 Oxford Tan','260','adidas','2015-12-30','217500','320000');
insert into product values (19,'imangel1234','null','adidas Yeezy 700 V3 Azael','280','adidas','2019-12-24','217700','540000');
insert into product values (20,'null','null','adidas Yeezy Boost 350 V2 Lundmark (Non Reflective)','250','adidas','2019-07-14','239400','270000');
insert into product values (21,'null','null','Nike x PEACEMINUSONE Air Force 1 Low Para-Noise (Korea Exclusive)','260','nike','2019-11-22','219000','330000');
insert into product values (22,'basketballs2','baegopa55','(W) Jordan 4 x Off-White Retro SP Sail','240','jordan','2011-11-11','269000','306000');
insert into product values (23,'ok1231','apple342','Nike Big Swoosh Full Zip Jacket Black Volt','250','nike','1999-12-05','129000','160000');
insert into product values (24,'null','null','Jordan 1 x J Balvin Retro High OG','260','jordan','2005-04-15','229000','480000');
insert into product values (25,'null','null','adidas Dame 4 A Bathing Ape Camo','250','adidas','2018-02-17','163200','530000');
insert into product values (26,'null','null','Nike x Stussy Beach Pant Off Noir','260','stussy','2017-09-22','169000','790000');
insert into product values (27,'null','null','Supreme x Stone Island Painted Camo Nylon 6-Panel Black (20FW)','250','supreme','2020-09-30','71800','890000');
insert into product values (28,'wonder486','yoons1234','Stussy x Off-White 40 WT Tee','230','stussy','2009-11-03','43500','437000');
insert into product values (29,'null','null','Supreme x Stone Island Painted Camo Crinkle Down Jacket Black (20FW)','250','supreme','2011-02-28','1086400','2790000');
insert into product values (30,'null','null','Nike x PEACEMINUSONE Air Force 1 Low Para-Noise 2.0','270','nike','2020-11-25','219000','250000');
insert into product values (31,'null','null','Supreme x Stone Island Corduroy Jacket Black (20FW)','250','supreme','2020-12-11','716200','600000');
insert into product values (32,'null','null','adidas x LEGO ZX 8000','270','adidas','2008-05-05','169000','200000');
insert into product values (33,'null','real-jorden','Nike Big Swoosh Full Zip Jacket Black Volt','240','nike','1999-12-05','129000','160000');
insert into product values (34,'null','null','Jordan 1 x J Balvin Retro High OG','245','jordan','2005-04-15','229000','480000');\
insert into product values (35,'null','null','adidas Dame 4 A Bathing Ape Camo','255','adidas','2018-02-17','163200','530000');
insert into product values (36,'null','null','Nike x Stussy Beach Pant Off Noir','265','stussy','2017-09-22','169000','790000');
insert into product values (37,'null','null','Supreme x Stone Island Painted Camo Nylon 6-Panel Black (20FW)','255','supreme','2020-09-30','71800','890000');
insert into product values (38,'null','gibgagopa','Stussy x Off-White 40 WT Tee','235','stussy','2009-11-03','43500','437000');
insert into product values (39,'null','null','Supreme x Stone Island Painted Camo Crinkle Down Jacket Black (20FW)','255','supreme','2011-02-28','1086400','2790000');
insert into product values (40,'null','null','Nike x PEACEMINUSONE Air Force 1 Low Para-Noise 2.0','275','nike','2020-11-25','219000','250000');
insert into product values (41,'null','null','Supreme x Stone Island Corduroy Jacket Black (20FW)','255','supreme','2020-12-11','716200','600000');
insert into product values (42,'null','null','adidas x LEGO ZX 8000','265','adidas','2008-05-05','169000','200000');

-- buyer INSERT
insert into buyer values ('ok1231',23,'권오민','010-1234-2345','인천광역시 연수구 송도동');
insert into buyer values ('rabbit777',4,'권희성','010-1234-2346','경기도 부천시 소사구 옥길동');
insert into buyer values ('wonder486',28,'김민건','010-1234-2347','인천광역시 남동구 구월1동');
insert into buyer values ('ilovecats2',6,'김성호','010-1234-2348','경기도 시흥시 정왕3동');
insert into buyer values ('gajagib98',7,'조윤혜','010-1234-2349','경기도 안산시 단원구 고잔동');
insert into buyer values ('imangel1234',19,'김재웅','010-1234-2350','경기도 안산시 상록구 본오3동');
insert into buyer values ('basketballs2',22,'김준형','010-1234-2351','강원도 철원군 김화읍');
insert into buyer values ('waterisbest234',1,'김창훈','010-1234-2352','경기도 안양시 동안구 달안동');
insert into buyer values ('loveletter',7,'양호준','010-1234-2353','경기도 분당구 백현동');

-- seller INSERT
insert into seller values ('yoons1234',28,'최지수','010-1235-7896','충청남도 공주시 공주읍');
insert into seller values ('gibgagopa',38,'장문희','010-1235-7897','강원도 원주시 지정면');
insert into seller values ('jordansarang',19,'염아정','010-1235-7898','충청북도 충주시 칠금동');
insert into seller values ('ename7535',8,'김연지','010-1235-7895','전라남도 강진군 강진읍');
insert into seller values ('real-jorden',33,'박민영','010-1235-7894','제주특별시 제주시 애월읍');
insert into seller values ('apple342',23,'고은비','010-1235-7893','전라북도 고창군 고창읍');
insert into seller values ('baegopa55',22,'이정민','010-1235-7892','경상남도 창원시 가포동');
insert into seller values ('jordanwant',1,'차왕현','010-1235-7891','부산광역시 사직구 사직동');
insert into seller values ('noniwa',6,'최태열','010-1235-7890','경기도 성남시 수정구 태평동');

COMMIT;
```

---

## ISSUE
<div> 
1. 잘못된 모델링 설계 

>1-1. 아이디어에서 설계로 넘어갈때 복잡하게 구조를 잡음 

>1-2. TABLE 간 ENTITY 설계에서 오류가 남 
    1)  수정 전:  Product (부모) -> Buyer, Seller (자식)
        Buyer, Seller 테이블에서 각각 필요한 product id를 참조해 상품정보를 불러옴
    2)  Buyer CRUD를 구현하는 과정에서 prodid를 참조만 하면 알 수 없는 오류가 났고, 
        부모와 자식테이블이 뒤바뀌었기 때문이라는 것을 깨달음
    3)  수정 후 : Product(자식) <- Buyer, Seller (부모)
                  product -> sellid , buyid(FK) 추가


2. OrderCRUDTest 실행의 문제점 

>1. 실행결과 오류가 뜨진 않지만 결과값이 나오지 않음 
    DB에는 존재하고 있어서 아직 해결방법을 알지 못함
---    

## INSPIRATION

3. 각자 힘들었던 점 

**장문희**

각 테이블 간 매핑관계에서 있었던 오류 수정 전, 잘못된 매핑관계로 product id를 불러오지 못하는 것이 가장 힘들었습니다.
product id를 불러오지 못하니 CRUD에서 각종 시나리오를 구현하는 데에 큰 장애물이 되었기 때문입니다. 
다행히 해결은 되었지만 처음 테이블을 구성할때 부모자식 관계를 적절히 선택하는 것은 신중해야 한다는 것을 깨닫는 계기가 되었습니다

**조윤혜**

테이블설계의 중요성을 알게되었습니다. 

**최지수**

각 테이블 간 매핑에 있어서 관계도를 생각하지 않고 아이디어를 기반으로 생각하고 구상하다 보니 테이블 매핑이 복잡해져서 erd diagram을 구성하는 내내 고민하고 힘들었던 것 같습니다.

**이민재**

기존 프로젝트와는 다르게 Table을 나누는 과정이 쉽지가 않았습니다.
실제로 중고거래 애플리케이션을 많이 써보았음에도 이를 DB화하는 것부터
PK, FK을 어떤 Table에 그리고 어떤 Column에 위치해야 하는지 위치선정부터
많이 고민을 했던 것 같습니다. 이 부분에서 상당히 시간을 할애한 것 같아
대단히 아쉬운 Project 였습니다.
의도한 바로는 모든 Query 문을 사용하고 싶었지만, 결국에는 기존 Review에 사용했던
내용을 복붙하는 수준에 그치고 말았습니다... 같이 고생해 준 저희 팀원에게 진심으로
죄송하다는 말씀을 드리면서 마무리하겠습니다.

