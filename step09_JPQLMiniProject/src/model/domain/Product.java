package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Id
	@OneToOne
	@Column(name ="prodid")
	private int prodid;

	@Column(name="prodname")
	private String prodname;

	@Column(name="prodsize")
	private int prodsize;
	
	@Column(name="brand")
	private String brand;

	@Column(name="release_date")
	private String release_date;
	
	@Column(name="price")
	private int price;

	@Column(name="resellprice")
	private int resellprice;
	
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", brand=" + brand
				+ ", release_date=" + release_date + ", price=" + price + ", sellers=" + sellers + ", buyers=" + buyers
				+ "]";
	}

}