package kurly.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import kurly.domain.dto.FeedBackUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int count;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(nullable = false)
	private String user_ip;
	
	@CreatedDate
	@Column(nullable = false)
	private LocalDateTime reg_date;

	@Builder
	public FeedBack(Long no, String subject, String content, int count, String writer, String user_ip,
			LocalDateTime reg_date) {
		this.no = no;
		this.subject = subject;
		this.content = content;
		this.count = count;
		this.writer = writer;
		this.user_ip = user_ip;
		this.reg_date = reg_date;
	}
	

	public FeedBack update(FeedBackUpdateDto update) {
		this.subject = update.getSubject();
		this.content = update.getContent();
		return this;
	}
	
	

}
