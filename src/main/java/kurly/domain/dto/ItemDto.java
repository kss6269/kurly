package kurly.domain.dto;

import java.time.LocalDateTime;

import kurly.domain.entity.Item;
import lombok.Data;

@Data
public class ItemDto {
	
	private Long no;
	private String subject;
	private String content;
	private String writer;
	private int count;
	private String user_ip;
	private LocalDateTime reg_date;
	

	public ItemDto(Item item) {
		super();
		this.no = item.getNo();
		this.subject = item.getSubject();
		this.content = item.getContent();
		this.writer = item.getWriter();
		this.count = item.getCount();
		this.user_ip = item.getUser_ip();
		this.reg_date = item.getReg_date();
	}
	
	
	

}
