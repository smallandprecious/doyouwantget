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

@SequenceGenerator(name="MEMBER_SEQ_GEN", sequenceName="MEMBER_SEQ_ID",
initialValue=1, allocationSize=50)
@Entity
public class Member {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_SEQ_GEN")
	@Id
	@Column(name="member_id")
	private String member_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birthday")
	private String birthday;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="adress")
	private String adress;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [member_id=");
		builder.append(member_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", phone_number=");
		builder.append(phone_number);
		builder.append(", adress=");
		builder.append(adress);
		builder.append("]");
		return builder.toString();
	}
}
