package kurly.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@Entity
@Table(name = "jpa_member")
public class Member {
	
	@Id
	private String id;
	@Column(nullable = false)
	private String pw;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	
	@CreatedDate
	private LocalDateTime reg_date;
	
	@Builder
	public Member(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}
	
	
}
