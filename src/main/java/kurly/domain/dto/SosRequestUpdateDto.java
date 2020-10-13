package kurly.domain.dto;

import kurly.domain.entity.Sos;
import lombok.Data;

@Data
public class SosRequestUpdateDto {
	
	private Long no;
	private String subject;
	private String content;
	

}
