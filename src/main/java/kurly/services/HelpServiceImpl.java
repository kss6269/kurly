package kurly.services;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kurly.domain.dto.HelpDto;
import kurly.domain.dto.HelpRequestDto;
import kurly.domain.dto.HelpResponseDto;
import kurly.domain.entity.Help;
import kurly.domain.entity.HelpRepository;

@Service
public class HelpServiceImpl implements HelpService{

	@Autowired
	private HelpRepository repository;
	
	@Override
	public void write(HelpRequestDto dto) {
		repository.save(dto.toEntity());
	}

	@Override
	public List<HelpDto> list() {
		List<Help> list = repository.findAll();
		List<HelpDto> help = new Vector<>();
		for(Help result : list) {
			HelpDto helpdto = new HelpDto(result);
			help.add(helpdto);
		}
		return help;
	}

	@Override
	public HelpDto detail(Long no) {
		Help help = repository.findById(no).orElse(null);
		HelpDto dto = new HelpDto(help);
		return dto;
	}

	@Transactional
	@Override
	public void edit(HelpResponseDto dto) {
		repository.findById(dto.getNo()).map(result->result.update(dto)).orElse(null);
		
	}

	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}


		
		


}
