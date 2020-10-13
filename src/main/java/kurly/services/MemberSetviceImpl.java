package kurly.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kurly.domain.dto.MemberLoginDto;
import kurly.domain.dto.MemberRequestDto;
import kurly.domain.entity.Member;
import kurly.domain.entity.MemberRepository;

@Service
public class MemberSetviceImpl implements MemberService{
	
	@Autowired
	private MemberRepository repository;
		
	@Override
	public void join(MemberRequestDto dto) {
		repository.save(dto.toEnity());
		
	}
	
	@Override
	public MemberLoginDto login(MemberLoginDto dto) {
		Member member = repository.findByIdAndPw(dto.getId(),dto.getPw());
		if(member==null) 
			return null;
		MemberLoginDto loginDto = new MemberLoginDto(member);
		return loginDto;
	}

	
	/*
	  @Override
	  public void addMember(MemberRequestDto dto) {
	  
	  repository.save(dto.toEntity()); }
	  */
	  
	 
	/*
	@Override
	public MemberLoginDto login(MemberLoginDto dto) {
		Member member=repository.findByIdAndPw(dto.getId(), dto.getPw());
		//Member-->MemberLoginDto
		if(member==null)
			return null;
		MemberLoginDto loginDto=new MemberLoginDto(member);
		
		return loginDto;
	}
	*/

	


}
