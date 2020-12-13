package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name="buyid")
	private String buyer_id;

	@Column(name="buyname")
	private String buyname;

	@Column(name="buyphonum")
	private String buyphonum;

	@Column(name="buyaddress")
	private String buyaddress;
	
	@OneToMany(mappedBy = "prodid")
	private List<Product> products;

	@OneToMany(mappedBy = "prodid")
	private List<Product> products;
	
	@Override
	public String toString() {
		return "Buyer [buyer_id=" + buyer_id + ", products=" + products + ", buyname=" + buyname + ", buyphonum="
				+ buyphonum + ", buyaddress=" + buyaddress + "]";
	}

}


