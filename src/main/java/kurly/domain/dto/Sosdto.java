package kurly.domain.dto;

import java.time.LocalDateTime;

import kurly.domain.entity.Sos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Sosdto {
	
	private Long no;
	private String subject;
	private String content;
	private int count;
	private String writer;
	private String user_ip;
	private LocalDateTime reg_date;
	
	public Sosdto(Sos sos) {
		super();
		this.no = sos.getNo();
		this.subject = sos.getSubject();
		this.content = sos.getContent();
		this.count = sos.getCount();
		this.writer = sos.getWriter();
		this.user_ip = sos.getUser_ip();
		this.reg_date = sos.getReg_date();
	}

}
