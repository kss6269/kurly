package kurly.domain.dto;

import kurly.domain.entity.Notice;
import lombok.Data;

@Data
public class NoticeUpdateDto {
	
	private String subject;
	private String content;
	
	public Notice toEntity() {
		return Notice.builder()
				.subject(subject)
				.content(content).build();
	}

}
