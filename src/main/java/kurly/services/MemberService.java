package kurly.services;

import kurly.domain.dto.MemberLoginDto;
import kurly.domain.dto.MemberRequestDto;
import kurly.domain.entity.Member;

public interface MemberService {


	//void addMember(MemberRequestDto dto);

	MemberLoginDto login(MemberLoginDto dto);

	void join(MemberRequestDto dto);


	

}
