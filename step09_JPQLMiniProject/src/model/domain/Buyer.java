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

@Entity
public class Buyer {
	@Id
	@Column(name="buyer_id")
	private String buyer_id;
	/*
	 * 
CREATE TABLE buyer ( 
buyer_id VARCHAR2(20) PRIMARY KEY, 
buy_name VARCHAR2(20) NOT NULL, 
buy_pho_num VARCHAR2(20) NOT NULL, 
buy_address VARCHAR2(20) NOT NULL, 
buy_size NUMBER(20) NOT NULL, 
hope_price NUMBER(20) NOT NULL
);
	 */
	
	@Column(name="buy_name")
	private String buy_name;
	
	@Column(name="buy_pho_num")
	private String buy_pho_num;
	
	@Column(name="buy_address")
	private String buy_address;
	
	@Column(name="buy_size")
	private int buy_size;
	
	@Column(name="hope_price")
	private int hope_price;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer [buyer_id=");
		builder.append(buyer_id);
		builder.append(", buy_name=");
		builder.append(buy_name);
		builder.append(", buy_pho_num=");
		builder.append(buy_pho_num);
		builder.append(", buy_address=");
		builder.append(buy_address);
		builder.append(", buy_size=");
		builder.append(buy_size);
		builder.append(", hope_price=");
		builder.append(hope_price);
		builder.append("]");
		return builder.toString();
	}



	}
}
