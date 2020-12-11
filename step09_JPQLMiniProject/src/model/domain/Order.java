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

@SequenceGenerator(name="ORDER_SEQ_GEN", sequenceName="ORDER_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Order {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_SEQ_GEN")
	@Id
	@Column(name="order_id")
	private Long order_id;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [order_id=");
		builder.append(order_id);
		builder.append("]");
		return builder.toString();
	}
}
