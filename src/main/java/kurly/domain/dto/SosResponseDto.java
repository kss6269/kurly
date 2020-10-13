package kurly.domain.dto;

import java.time.LocalDateTime;

import kurly.domain.entity.Sos;
import lombok.Data;

@Data
public class SosResponseDto {
	
	private Long no;
	private String subject;
	private String content;
	private int count;
	private String writer;
	private String user_ip;
	private LocalDateTime reg_date;
	
	
	public SosResponseDto(Sos sos) {
		no = sos.getNo();
		subject = sos.getSubject();
		content = sos.getContent();
		count = sos.getCount();
		writer = sos.getWriter();
		user_ip = sos.getUser_ip();
		reg_date = sos.getReg_date();
	}
	
	

}
