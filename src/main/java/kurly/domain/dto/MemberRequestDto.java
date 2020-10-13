package kurly.domain.dto;

import kurly.domain.entity.Member;
import lombok.Data;
import lombok.Getter;


@Data
public class MemberRequestDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	
	/*public Member toEntity() {
		//return new Member(id,pw,name,email);
		return Member.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.email(email)
				.build();
		}
	*/	
	 
		public Member toEnity() {
			return new Member(id,pw,name,email);
		}
	
}
