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


@Entity
public class Product {
	@Id
	@Column(name="product_id")
	private String product_id;
	@OneToMany(mappedBy = "product_id")
	private List<Seller> sellers;
	private List<Buyer> buyers;
	
	
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