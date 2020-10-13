package kurly.services;

import java.util.List;

import kurly.domain.dto.HelpDto;
import kurly.domain.dto.HelpRequestDto;
import kurly.domain.dto.HelpResponseDto;

public interface HelpService {

	void write(HelpRequestDto dto);

	List<HelpDto> list();

	HelpDto detail(Long no);

	void edit(HelpResponseDto dto);

	void delete(Long no);

}
