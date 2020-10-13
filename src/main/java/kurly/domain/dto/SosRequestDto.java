package kurly.domain.dto;

import kurly.domain.entity.Sos;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SosRequestDto {
	private String subject;
	private String content;
	private String writer;
	private String user_ip;
	
	public Sos toEntity() {
		return Sos.builder()
				.subject(subject)
				.content(content)
				.writer(writer)
				.user_ip(user_ip)
				.build(); 
	}
	

}
