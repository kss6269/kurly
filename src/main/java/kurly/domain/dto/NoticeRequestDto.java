package kurly.domain.dto;

import kurly.domain.entity.Notice;
import lombok.Data;

@Data
public class NoticeRequestDto {
	private String subject;
	private String content;
	private String writer;
	private String user_ip;
	
	public Notice toEntity() {
		return Notice.builder()
				.subject(subject)
				.content(content)
				.writer(writer)
				.user_ip(user_ip)
				.build();
	}
}
