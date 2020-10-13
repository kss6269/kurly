package kurly.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@SequenceGenerator(
		name = "Notice_seq_Generator",
		sequenceName = "SEQ_NOTICE",
		initialValue = 1,
		allocationSize = 1
		)
@Table(name = "notice")
@Entity()
public class Notice {
	
	@Id//pk임을 표현
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Notice_seq_Generator")
	private Long no;
	
	@Column(nullable = false)//not null
	private String subject;
	@Column(nullable = false)
	private String writer;
	@Column(nullable = false)
	private String user_ip;
	@Column(columnDefinition ="TEXT" ,nullable = false)
	private String content;
	private int count;
	
	
	@Column(nullable = false)
	private LocalDateTime reg_date=LocalDateTime.now();
	
	
	@Builder
	public Notice(String subject, String writer, String user_ip, String content) {
		this.subject = subject;
		this.writer = writer;
		this.user_ip = user_ip;
		this.content = content;
	}
	
	public void update(String subject, String content){
		this.subject = subject;
		this.content = content;
	}
	
	

}
