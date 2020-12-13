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
#### Structure


<div>
    <img width="800" src="https://user-images.githubusercontent.com/73386460/102009493-17881c80-3d7b-11eb-9519-f9fe447b0689.PNG">
</div>

--------------

## Service 

--------------

#### [Buyer, 구매자 시나리오]

-------------

1. 

2.

3. 

--------------

#### [Seller, 판매자 시나리오]

1.

2.

3. 

----------------
#### [Seller, 판매자 시나리오]

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



```

-------------

### Order CRUD 구현 과정

```



```

------------

## SQL TABLE

++++DDL

```SQL
DROP TABLE product CASCADE CONSTRAINTS;

DROP TABLE buyer CASCADE CONSTRAINTS;

DROP TABLE seller CASCADE CONSTRAINTS;


CREATE TABLE product (
	prodid	        NUMBER(10)	     PRIMARY KEY,
        buyid           VARCHAR2(20),
        sellerid        VARCHAR2(20),    
	prodname	VARCHAR2(255)	      NOT NULL,
	prodsize        NUMBER(3)	      NOT NULL,
	brand	        VARCHAR2(100)	      NOT NULL,
	release_date    VARCHAR2(20)	      NOT NULL,
	price	        NUMBER(10)            NOT NULL,
        resellprice	NUMBER(10)           NOT NULL
);

CREATE TABLE buyer (
	buyid  	         VARCHAR2(50)		PRIMARY KEY,
	prodid	         NUMBER(10)		NOT NULL,
	buyname	         VARCHAR2(50)		NOT NULL,
	buyphonum	 VARCHAR2(50)		NOT NULL,
	buyaddress	 VARCHAR2(50)		NOT NULL
);

CREATE TABLE seller (
	sellid            VARCHAR2(50)		PRIMARY KEY,
	prodid	          NUMBER(10)		NOT NULL,
	selname	          VARCHAR2(50)		NOT NULL,
	selphonum	  VARCHAR2(50)		NOT NULL,
	seladdress        VARCHAR2(50)		NOT NULL
);

ALTER TABLE buyer ADD CONSTRAINT FK_product_TO_buyer_1 FOREIGN KEY (prodid)
REFERENCES product (prodid);

ALTER TABLE seller ADD CONSTRAINT FK_product_TO_seller_1 FOREIGN KEY (prodid)
REFERENCES product (prodid);
```

++++DML

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
insert into product values (34,'null','null','Jordan 1 x J Balvin Retro High OG','245','jordan','2005-04-15','229000','480000');												
insert into product values (35,'null','null','adidas Dame 4 A Bathing Ape Camo','255','adidas','2018-02-17','163200','530000');												
insert into product values (36,'null','null','Nike x Stussy Beach Pant Off Noir','265','stussy','2017-09-22','169000','790000');												
insert into product values (37,'null','null','Supreme x Stone Island Painted Camo Nylon 6-Panel Black (20FW)','255','supreme','2020-09-30','71800','890000');												
insert into product values (38,'null','gibgagopa','Stussy x Off-White 40 WT Tee','235','stussy','2009-11-03','43500','437000');												
insert into product values (39,'null','null','Supreme x Stone Island Painted Camo Crinkle Down Jacket Black (20FW)','255','supreme','2011-02-28','1086400','2790000');												
insert into product values (40,'null','null','Nike x PEACEMINUSONE Air Force 1 Low Para-Noise 2.0','275','nike','2020-11-25','219000','250000');												
insert into product values (41,'null','null','Supreme x Stone Island Corduroy Jacket Black (20FW)','255','supreme','2020-12-11','716200','600000');												
insert into product values (42,'null','null','adidas x LEGO ZX 8000','265','adidas','2008-05-05','169000','200000');

-- buyer INSERT
insert into buyer values ('ok1231','23','권오민','010-1234-2345','인천광역시 연수구 송도동');
insert into buyer values ('rabbit777','4','권희성','010-1234-2346','경기도 부천시 소사구 옥길동');
insert into buyer values ('wonder486','28','김민건','010-1234-2347','인천광역시 남동구 구월1동');
insert into buyer values ('ilovecats2','6','김성호','010-1234-2348','경기도 시흥시 정왕3동');
insert into buyer values ('gajagib98','7','조윤혜','010-1234-2349','경기도 안산시 단원구 고잔동');
insert into buyer values ('imangel1234','19','김재웅','010-1234-2350','경기도 안산시 상록구 본오3동');
insert into buyer values ('basketballs2','22','김준형','010-1234-2351','강원도 철원군 김화읍');
insert into buyer values ('waterisbest234','1','김창훈','010-1234-2352','경기도 안양시 동안구 달안동');
insert into buyer values ('loveletter','7','양호준','010-1234-2353','경기도 분당구 백현동');

-- seller INSERT
insert into seller values ('yoons1234','28','최지수','010-1235-7896','충청남도 공주시 공주읍');
insert into seller values ('gibgagopa','38','장문희','010-1235-7897','강원도 원주시 지정면');
insert into seller values ('jordansarang','19','염아정','010-1235-7898','충청북도 충주시 칠금동');
insert into seller values ('ename7535','8','김연지','010-1235-7895','전라남도 강진군 강진읍');
insert into seller values ('real-jorden','33','박민영','010-1235-7894','제주특별시 제주시 애월읍');
insert into seller values ('apple342','23','고은비','010-1235-7893','전라북도 고창군 고창읍');
insert into seller values ('baegopa55','22','이정민','010-1235-7892','경상남도 창원시 가포동');
insert into seller values ('jordanwant','1','차왕현','010-1235-7891','부산광역시 사직구 사직동');
insert into seller values ('noniwa','6','최태열','010-1235-7890','경기도 성남시 수정구 태평동');

COMMIT;
```


