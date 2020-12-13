package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "Seller")
public class Seller {
	@Id
	@Column(name="seller_id")
	private String seller_id;

	@Column(name="sel_name")
	private String name;

	@Column(name="sel_pho_num")
	private String phone_number;

	@Column(name="sel_address")
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
		return "Seller [seller_id=" + seller_id + ", name=" + name + ", phone_number=" + phone_number + ", address="
				+ address + ", product_size=" + product_size + ", resell_price=" + resell_price + ", product_id="
				+ product_id + "]";
	}

}
