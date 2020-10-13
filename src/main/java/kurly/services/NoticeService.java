package kurly.services;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.NoticeRequestDto;
import kurly.domain.dto.NoticeResponseDto;
import kurly.domain.dto.NoticeUpdateDto;
import kurly.domain.entity.Notice;

public interface NoticeService {

	ModelAndView listAll(int page);

	void addNotice(NoticeRequestDto dto);

	Notice detail(Long no);

	void update(NoticeUpdateDto dto, Long no);

	void delete(Long no);

}
