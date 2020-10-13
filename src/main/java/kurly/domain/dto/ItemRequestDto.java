package kurly.domain.dto;

import kurly.domain.entity.Item;
import lombok.Data;

@Data
public class ItemRequestDto {
	
	private String subject;
	private String content;
	private String writer;
	private String user_ip;
	
	public Item toEntity() {
		return Item.builder()
				.subject(subject)
				.content(content)
				.writer(writer)
				.user_ip(user_ip)
				.build();
	}

}
