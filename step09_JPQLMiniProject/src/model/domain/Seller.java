package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude="products")

@Entity
@Table(name = "Seller")
public class Seller {
	@Id
	@Column(name="sellid")
	private String sellid;

	@Column(name="selname")
	private String selname;

	@Column(name="selphonum")
	private String selphonum;

	@Column(name="seladdress")
	private String seladdress;

	@OneToMany(mappedBy = "Sellerid")
	private List<Product> products;

//	@Override
//	public String toString() {
//		return "Seller [sellid=" + sellid + ", selname=" + selname + ","
//				+ " selphonum=" + selphonum + ", seladdress="
//				+ seladdress + ", products=" + products + "]";
//	}
	

}
	

	
