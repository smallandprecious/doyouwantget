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

@SequenceGenerator(name="SELLER_SEQ_GEN", sequenceName="SELLER_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Seller {
	@Id
	@Column(name="seller_id")
	private String seller_id;
	
<<<<<<< HEAD
	@Column(name="product_id")
	private int product_id;
	
	@Column(name="sel_name")
	private String sel_name;
=======
	@Column(name="name")
	private String name;
>>>>>>> 94e82a5d514b50e3b78b874720f9468d353fa532
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="address")
	private String address;
	
	@Column(name="product_size")
	private int product_size;
	
	@Column(name="resell_price")
	private int resell_price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product_id;

	@Override
	public String toString() {
<<<<<<< HEAD
		StringBuilder builder = new StringBuilder();
		builder.append("Seller [seller_id=");
		builder.append(seller_id);
		builder.append(", product_id=");
		builder.append(product_id);
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
=======
		return "Seller [seller_id=" + seller_id + ", name=" + name + ", phone_number=" + phone_number + ", address="
				+ address + ", product_size=" + product_size + ", resell_price=" + resell_price + ", product_id="
				+ product_id + "]";
>>>>>>> 94e82a5d514b50e3b78b874720f9468d353fa532
	}


	
	

}
