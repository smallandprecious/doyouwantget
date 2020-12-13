package model.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
<<<<<<< HEAD
	@Column(name="product_id")
	private int product_id;

	@Column(name="buy_name")
	private String buy_name;
=======
	@Column(name="name")
	private String name;
>>>>>>> 94e82a5d514b50e3b78b874720f9468d353fa532
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="address")
	private String address;
	
	@Column(name="buyer_size")
	private int buyer_size;
	
	@Column(name="hope_price")
	private int hope_price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product_id;

	@Override
	public String toString() {
<<<<<<< HEAD
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer [buyer_id=");
		builder.append(buyer_id);
		builder.append(", product_id=");
		builder.append(product_id);
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
=======

		return "Buyer [buyer_id=" + buyer_id + ", name=" + name + ", phone_number=" + phone_number + ", address="
				+ address + ", buyer_size=" + buyer_size + ", hope_price=" + hope_price + "]";
>>>>>>> 94e82a5d514b50e3b78b874720f9468d353fa532
	}
		

	}


<<<<<<< HEAD


	}
}
=======
>>>>>>> 94e82a5d514b50e3b78b874720f9468d353fa532
