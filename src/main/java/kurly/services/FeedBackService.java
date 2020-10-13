package kurly.services;

import java.util.List;

import kurly.domain.dto.FeedBackDto;
import kurly.domain.dto.FeedBackRequestDto;
import kurly.domain.dto.FeedBackUpdateDto;

public interface FeedBackService {

	void save(FeedBackRequestDto dto);

	List<FeedBackDto> findAll();

	FeedBackDto findById(Long no);

	void delete(Long no);

	void update(FeedBackUpdateDto dto);


}
