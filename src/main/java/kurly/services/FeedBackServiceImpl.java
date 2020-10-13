package kurly.services;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kurly.domain.dto.FeedBackDto;
import kurly.domain.dto.FeedBackRequestDto;
import kurly.domain.dto.FeedBackUpdateDto;
import kurly.domain.entity.FeedBack;
import kurly.domain.entity.FeedBackRepository;

@Service
public class FeedBackServiceImpl implements FeedBackService{

	
	@Autowired
	private FeedBackRepository repository;
	
	
	@Override
	public void save(FeedBackRequestDto dto) {
		repository.save(dto.toEntity());
		
	}

	@Override
	public List<FeedBackDto> findAll() {
		List<FeedBack> result = repository.findAll();
		List<FeedBackDto> list = new Vector<>();
		for(FeedBack dto :result) {
			FeedBackDto fb = new FeedBackDto(dto);
			list.add(fb);
		}
		return list;
	}

	@Override
	public FeedBackDto findById(Long no) {
		FeedBack result = repository.findById(no).orElse(null);
		FeedBackDto dto = new FeedBackDto(result);
		return dto;
	}
	
	@Override
	public void update(FeedBackUpdateDto dto) {
		repository.findById(dto.getNo()).map(result->result.update(dto)).orElse(null);
		
	}

	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}

	

}
