package kurly.services;

import java.util.List;
import java.util.Vector;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.PageMaker;
import kurly.domain.dto.SosRequestDto;
import kurly.domain.dto.SosRequestUpdateDto;
import kurly.domain.dto.SosResponseDto;
import kurly.domain.dto.Sosdto;
import kurly.domain.entity.Sos;
import kurly.domain.entity.SosRepository;

@Service
public class SosServiceImpl implements SosService{
	
	@Autowired
	private SosRepository repository;

	@Override
	public void insert(SosRequestDto dto) {
		repository.save(dto.toEntity());
	}

	@Override
	public ModelAndView findAll(int page) {
		Sort sort=Sort.by(Direction.DESC, "no");//정렬.by(내림차순, 기준컬럼명)
		int size=5;//한페이지에 표현할 게시글 수
		Pageable pageable=PageRequest.of(page-1, size, sort);
		Page<Sos> pageInfo = repository.findAll(pageable);
		
		List<Sos> list = pageInfo.getContent();
		PageMaker pageMaker = new PageMaker(page, pageInfo.getTotalPages());
		
		//Sos->Sosdto 로 변환 
		List<SosResponseDto> dtolist = new Vector<>();
		for(Sos sos : list) {
			SosResponseDto dto = new SosResponseDto(sos);
			dtolist.add(dto);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("noticeList", dtolist);
		mv.addObject("pageMaker", pageMaker);
		return mv;
	}

	@Override
	public Sosdto findById(Long no) {
		Sos detail = repository.findById(no).orElse(null);
		Sosdto dto = new Sosdto(detail);
		return dto;
	}

	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}
	
	@Transactional
	@Override
	public void update(SosRequestUpdateDto dto) {
		repository.findById(dto.getNo()).map(result->result.update(dto)).orElse(null);
		
	}

	
	
	/*
	@Override
	public void save(SosRequestDto dto) {
		repository.save(dto.toEnity());
	}

	
	@Override
	public List<Sosdto> listAll() {
		List<Sos> result = repository.findAll();
		List<Sosdto> list = new Vector<>();
		for(Sos sos : result) {
			Sosdto board = new Sosdto(sos);
			list.add(board);
		}
		return list;
	}

	@Override
	public Sosdto detail(Long no) {
		Sos result = repository.findById(no).orElse(null);
		Sosdto dto = new Sosdto(result);
		return dto;
	}

	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}

	@Transactional
	@Override
	public void update(SosRequestUpdateDto update) {
		repository.findById(update.getNo()).map(result->result.update(update)).orElse(null);
		
	}
	*/
	
	
	

}
