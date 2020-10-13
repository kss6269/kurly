package kurly.domain.dto;

import java.time.LocalDateTime;

import kurly.domain.entity.FeedBack;
import lombok.Data;

@Data
public class FeedBackDto {
	
	private Long no;
	private String subject;
	private String content;
	private String writer;
	private String user_ip;
	private int count;
	private LocalDateTime reg_date;
	
	public FeedBackDto(FeedBack feedback) {
		this.no = feedback.getNo();
		this.subject = feedback.getSubject();
		this.content = feedback.getContent();
		this.writer = feedback.getWriter();
		this.user_ip = feedback.getUser_ip();
		this.count = feedback.getCount();
		this.reg_date = feedback.getReg_date();
	}
	
	

}
