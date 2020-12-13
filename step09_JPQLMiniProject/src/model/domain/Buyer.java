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

@Entity
@Table(name = "Buyer")
public class Buyer {
	@Id
	@Column(name="buyer_id")
	private String buyer_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="buy_pho_num")
	private String phone_number;
	
	@Column(name="buy_address")
	private String address;
	
	@Column(name="buy_size")
	private int buy_size;
	
	@Column(name="hope_price")
	private int hope_price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product_id;

	@Override
	public String toString() {

		return "Buyer [buyer_id=" + buyer_id + ", name=" + name + ", phone_number=" + phone_number + ", address="
				+ address + ", buy_size=" + buy_size + ", hope_price=" + hope_price + "]";
	}
		

	}


