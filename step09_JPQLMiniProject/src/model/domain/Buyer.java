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

@SequenceGenerator(name="BUYER_SEQ_GEN", sequenceName="BUYER_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Buyer {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUYER_SEQ_GEN")
	@Id
	@Column(name="member_id")
	private String member_id;
	
	@Column(name="product_size")
	private int product_size;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer [member_id=");
		builder.append(member_id);
		builder.append(", product_size=");
		builder.append(product_size);
		builder.append("]");
		return builder.toString();
	}
}
