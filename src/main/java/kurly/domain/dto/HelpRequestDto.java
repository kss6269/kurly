package kurly.domain.dto;

import kurly.domain.entity.Help;
import lombok.Data;

@Data
public class HelpRequestDto {
	
	private String subject;
	private String content;
	private String writer;
	private String user_ip;
	
	public Help toEntity() {
		return Help.builder()
				.subject(subject)
				.content(content)
				.writer(writer)
				.user_ip(user_ip)
				.build();
				
	}

}
