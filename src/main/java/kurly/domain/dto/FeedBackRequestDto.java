package kurly.domain.dto;

import kurly.domain.entity.FeedBack;
import lombok.Data;

@Data
public class FeedBackRequestDto {
	
	private String subject;
	private String content;
	private String writer;
	private String user_ip;
	
	public FeedBack toEntity() {
		return FeedBack.builder()
				.subject(subject)
				.content(content)
				.writer(writer)
				.user_ip(user_ip)
				.build();
	}

}
