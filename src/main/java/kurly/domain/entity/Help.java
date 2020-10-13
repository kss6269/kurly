package kurly.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import kurly.domain.dto.HelpResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Help {
	
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
	public Help(Long no, String subject, String content, int count, String writer, String user_ip,
			LocalDateTime reg_date) {
		this.no = no;
		this.subject = subject;
		this.content = content;
		this.count = count;
		this.writer = writer;
		this.user_ip = user_ip;
		this.reg_date = reg_date;
	}
	
	public Help update(HelpResponseDto dto) {
		this.subject = dto.getSubject();
		this.content = dto.getContent();
		return this;
	}


	

	
	
	
	


}
