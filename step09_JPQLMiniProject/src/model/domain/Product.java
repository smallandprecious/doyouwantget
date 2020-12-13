package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@SequenceGenerator(name="PRODUCT_SEQ_GEN", sequenceName="PRODUCT_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Product {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_SEQ_GEN")
	@Id
	@Column(name="product_id")
	private int product_id;
	/*
	 * CREATE TABLE product(
    product_id VARCHAR2(30) PRIMARY KEY,
    buyer_id VARCHAR2(20) NOT NULL,
    seller_id VARCHAR2(20) NOT NULL,
    product_name VARCHAR2(100) NOT NULL,
    brand VARCHAR2(30) NOT NULL,
    release_date VARCHAR2(20) NOT NULL,
    price NUMBER(20) NOT NULL
);
	 */

	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="release_date")
	private String release_date;
	
	@Column(name="price")
	private int price;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [product_id=");
		builder.append(product_id);
		builder.append(", product_name=");
		builder.append(product_name);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", release_date=");
		builder.append(release_date);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}


	

	}
}