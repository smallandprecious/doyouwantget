package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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


@SequenceGenerator(name="PRODUCT_SEQ_GEN", sequenceName="PRODUCT_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Product {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_SEQ_GEN")
	@Id
	@Column(name ="product_id")
	private int product_id;	
	
	@OneToMany(mappedBy = "product_id")
	private List<Seller> sellers;
	private List<Buyer> buyers;
	
	@JoinColumn(name="buyer_id")
	private String buyer_id;
	
	@JoinColumn(name="seller_id")
	private String seller_id;
	
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
		return "Product [buyers=" + buyers + ", buyer_id=" + buyer_id + ", seller_id=" + seller_id + ", product_name="
				+ product_name + ", brand=" + brand + ", release_date=" + release_date + ", price=" + price + "]";
	}

	
	
	
}