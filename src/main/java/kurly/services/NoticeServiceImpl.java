package kurly.services;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.NoticeRequestDto;
import kurly.domain.dto.NoticeResponseDto;
import kurly.domain.dto.NoticeUpdateDto;
import kurly.domain.dto.PageMaker;
import kurly.domain.entity.Notice;
import kurly.domain.entity.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public ModelAndView listAll(int page) {
		Sort sort=Sort.by(Direction.DESC, "no");
		int size=5;//한페이지에 표현할 게시글 수
		Pageable pageable=PageRequest.of(page-1, size, sort);
		Page<Notice> pageInfo=noticeRepository.findAll(pageable);
		
		//System.out.println(pageInfo.getTotalPages());//총페이지수
		//System.out.println(pageInfo.getNumberOfElements());//현재페이지의 게시글수
		//System.out.println(pageInfo.getNumber());//현재 페이지번호 0~
		//System.out.println(pageInfo.getSize()); //한페이에 표현할 최대 게시글수
		//System.out.println(pageInfo.getTotalElements());//총게시글수
		//System.out.println(pageInfo.isFirst());//첫페이지여부
		//System.out.println(pageInfo.isLast());//마지막페이지 여부
		//System.out.println(pageInfo.hasNext());//앞페이지 존재여부
		//System.out.println(pageInfo.hasPrevious());//뒤페이지 존재여부
		
		List<Notice> list=pageInfo.getContent();
		
		PageMaker pageMaker =new PageMaker(page, pageInfo.getTotalPages());
		//notice -> NoticeResponseDto 변환
		List<NoticeResponseDto> dtoList=new Vector<>();
		for(Notice notice : list){
			NoticeResponseDto responseDto=new NoticeResponseDto(notice);
			dtoList.add(responseDto);
		}
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("noticeList", dtoList);
		mv.addObject("pageMaker", pageMaker);
		
		return mv;
	}

	@Override
	public void addNotice(NoticeRequestDto dto) {
		noticeRepository.save(dto.toEntity());
		
	}

	@Override
	public Notice detail(Long no) {
		Optional<Notice> opt=noticeRepository.findById(no);
		return opt.get();
	}
	
	@Transactional
	@Override
	public void update(NoticeUpdateDto dto, Long no) {
		/*
		 Optional<Notice> opt=noticeRepository.findById(no) 
		 Notice orgData=opt.get();
		 orgData.setSubject(dto.getSubject()); 
		 orgData.setContent(dto.getContent());
		 //System.out.println(orgData); 
		 noticeRepository.save(orgData);
		//*/
		
		Notice notice= noticeRepository.findById(no).orElseThrow(
						()->new IllegalArgumentException("해당 게시글이 없습니다.")
				);
		notice.update(dto.getSubject(), dto.getContent());
		//notice.setSubject(dto.getSubject()); 
		//notice.setContent(dto.getContent());
		
	}

	@Override
	public void delete(Long no) {
		
		noticeRepository.deleteById(no);
		
	}

}
