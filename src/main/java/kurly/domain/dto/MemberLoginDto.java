package kurly.domain.dto;

import kurly.domain.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberLoginDto {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public MemberLoginDto(Member loginDto) {
		super();
		this.id = loginDto.getId();
		this.pw = loginDto.getPw();
		this.name = loginDto.getName();
		this.email = loginDto.getEmail();
				
	}
	
	
	
	

}
