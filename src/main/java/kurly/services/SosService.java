package kurly.services;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.SosRequestDto;
import kurly.domain.dto.SosRequestUpdateDto;
import kurly.domain.dto.SosResponseDto;
import kurly.domain.dto.Sosdto;

public interface SosService {

	void insert(SosRequestDto dto);

	ModelAndView findAll(int page);

	Sosdto findById(Long no);

	void delete(Long no);

	void update(SosRequestUpdateDto dto);


	
	/*
	void save(SosRequestDto dto);

	List<Sosdto> listAll();

	Sosdto detail(Long no);

	void delete(Long no);

	void update(SosRequestUpdateDto update);
	*/





}
