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
	//@ManyToOne()
	@Column(name="buyer_id")
	private String buyer_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="address")
	private String address;
	
	@Column(name="buyer_size")
	private int buyer_size;
	>>>>>>> e31ab8d122068aa7f293b5c2f52fe0784e0df1dc
	@Column(name="hope_price")
	private int hope_price;

	@Override
	public String toString() {

		return "Buyer [buyer_id=" + buyer_id + ", name=" + name + ", phone_number=" + phone_number + ", address="
				+ address + ", buyer_size=" + buyer_size + ", hope_price=" + hope_price + "]";
	}
		

	}

}
