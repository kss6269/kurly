package kurly.domain.dto;

import java.time.LocalDateTime;

import kurly.domain.entity.Notice;
import lombok.Data;

@Data
public class NoticeResponseDto {
	private Long no;
	private String subject;
	private String writer;
	private String user_ip;
	private String content;
	private int count;
	private LocalDateTime reg_date;
	
	public NoticeResponseDto(Notice notice){
		no=notice.getNo();
		subject=notice.getSubject();
		writer=notice.getWriter();
		user_ip=notice.getUser_ip();
		content=notice.getContent();
		count=notice.getCount();
		reg_date=notice.getReg_date();
	}
}
