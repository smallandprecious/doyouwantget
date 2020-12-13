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

@SequenceGenerator(name="SELLER_SEQ_GEN", sequenceName="SELLER_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Seller {
	@Id
	@Column(name="seller_id")
	private String seller_id;
	
//	CREATE TABLE seller ( 
//			seller_id VARCHAR2(20) NOT NULL PRIMARY KEY, 
//			sel_name VARCHAR2(20) NOT NULL, 
//			sel_pho_num VARCHAR2(20) NOT NULL, 
//			sel_address VARCHAR2(20) NOT NULL, 
//			product_size NUMBER(20)	NOT NULL, 
//			resell_price NUMBER(20) NOT NULL
//			);
	@Column(name="sel_name")
	private String sel_name;
	
	@Column(name="sel_pho_num")
	private String sel_pho_num;
	
	@Column(name="sel_address")
	private String sel_address;
	
	@Column(name="product_size")
	private int product_size;
	
	@Column(name="resell_price")
	private int resell_price;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Seller [seller_id=");
		builder.append(seller_id);
		builder.append(", sel_name=");
		builder.append(sel_name);
		builder.append(", sel_pho_num=");
		builder.append(sel_pho_num);
		builder.append(", sel_address=");
		builder.append(sel_address);
		builder.append(", product_size=");
		builder.append(product_size);
		builder.append(", resell_price=");
		builder.append(resell_price);
		builder.append("]");
		return builder.toString();
	}
	
	
}
