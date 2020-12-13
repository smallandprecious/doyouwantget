DROP TABLE product cascade constraints;

DROP TABLE buyer cascade constraints;

DROP TABLE seller cascade constraints;


CREATE TABLE product(
    product_id VARCHAR2(30) PRIMARY KEY,
    product_name VARCHAR2(100) NOT NULL,
    brand VARCHAR2(30) NOT NULL,
    release_date VARCHAR2(20) NOT NULL,
    price NUMBER(20) NOT NULL
);

CREATE SEQUENCE PRODUCT_PRODUCT_ID_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999;

CREATE TABLE buyer ( 
buyer_id VARCHAR2(20) PRIMARY KEY, 
product_id VARCHAR2(30) NOT NULL,
buy_name VARCHAR2(20) NOT NULL, 
buy_pho_num VARCHAR2(20) NOT NULL, 
buy_address VARCHAR2(20) NOT NULL, 
buy_size NUMBER(20) NOT NULL, 
hope_price NUMBER(20) NOT NULL
);

CREATE TABLE seller ( 
seller_id VARCHAR2(20) NOT NULL PRIMARY KEY, 
product_id VARCHAR2(30) NOT NULL,
sel_name VARCHAR2(20) NOT NULL, 
sel_pho_num VARCHAR2(20) NOT NULL, 
sel_address VARCHAR2(20) NOT NULL, 
product_size NUMBER(20)	NOT NULL, 
resell_price NUMBER(20) NOT NULL
);

ALTER TABLE buyer ADD FOREIGN KEY (product_id) REFERENCES product (product_id);
ALTER TABLE seller ADD FOREIGN KEY (product_id) REFERENCES product (product_id);

