package kurly.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import kurly.domain.dto.ItemRequestUpdate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "item")
@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private Long no;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(nullable = false)
	private String user_ip;
	
	@Column(columnDefinition ="text" ,nullable = false)
	private String content;
	
	private int count;
	
	@CreatedDate //데이터가 처음 만들어질때 자동생성
	@Column(nullable = false)
	private LocalDateTime reg_date;

	
	@Builder
	public Item(Long no, String subject, String writer, String user_ip, String content, int count,
			LocalDateTime reg_date) {
		super();
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.user_ip = user_ip;
		this.content = content;
		this.count = count;
		this.reg_date = reg_date;
	}


	public Item update(ItemRequestUpdate dto) {
		this.subject = dto.getSubject();
		this.content = dto.getContent();
		return this;
	}
	
	
	
	
	
	
	
	
	

}
