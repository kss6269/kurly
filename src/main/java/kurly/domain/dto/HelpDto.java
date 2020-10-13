package kurly.domain.dto;

import java.time.LocalDateTime;

import kurly.domain.entity.Help;
import lombok.Data;

@Data
public class HelpDto {
	
	private Long no;
	private String subject;
	private String content;
	private int count;
	private String writer;
	private String user_ip;
	private LocalDateTime reg_date;
	
	public HelpDto(Help help) {
		this.no = help.getNo();
		this.subject = help.getSubject();
		this.content = help.getContent();
		this.count = help.getCount();
		this.writer = help.getWriter();
		this.user_ip = help.getUser_ip();
		this.reg_date = help.getReg_date();
	}
	
	


}
