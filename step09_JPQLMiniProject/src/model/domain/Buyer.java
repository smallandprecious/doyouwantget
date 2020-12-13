package model.domain;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
public class Buyer {
	@Id
	@Column(name="buyid")
	private String buyer_id;

	@OneToMany(mappedBy = "prodid")
	private List<Product> products;
	
	@Column(name="buyname")
	private String buyname;

	@Column(name="buyphonum")
	private String buyphonum;

	@Column(name="buyaddress")
	private String buyaddress;

	@Override
	public String toString() {
		return "Buyer [buyer_id=" + buyer_id + ", products=" + products + ", buyname=" + buyname + ", buyphonum="
				+ buyphonum + ", buyaddress=" + buyaddress + "]";
	}

	


}


