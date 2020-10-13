package kurly.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.NoticeRequestDto;
import kurly.domain.dto.NoticeUpdateDto;
import kurly.domain.entity.Notice;
import kurly.services.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/")
	public String home() {
		return "/index";
	}
	
	@GetMapping("/notice/{page}")
	public ModelAndView boardHome(@PathVariable int page) {
		//ModelAndView mv=new ModelAndView("/notice/list");// /notice/list.html
		ModelAndView mv=noticeService.listAll(page);
		mv.setViewName("/notice/list");
		mv.addObject("today", LocalDateTime.now());
		
		return mv;
	}
	
	@GetMapping("/notice/write")
	public String writePage() {
		return "/notice/write";// /notice/write.html
	}
	
	@PostMapping("/notice/write")
	public String write(NoticeRequestDto dto, HttpServletRequest request) {
		//페이지에서 요청한 데이터를 받아서
		dto.setUser_ip(request.getRemoteAddr());
		System.out.println(dto);
		//DB에 저장후
		noticeService.addNotice(dto);
		//페이지이동 은 list.html로 이동
		return "redirect:/notice/1";// 
	}
	
	@GetMapping("/notice/detail/{no}")
	public ModelAndView detail(@PathVariable Long no) {
		//요청된 게시글 번호를 이용하여 DB에서 상세정보 갖고옵시다.
		ModelAndView mv=new ModelAndView("/notice/detail");///notice/detail.html
		Notice detail=noticeService.detail(no);
		mv.addObject("detail",detail);
		
		return mv;
	}
	
	@PostMapping("/notice/edit")
	public String edit(NoticeUpdateDto dto, @Param(value = "no")Long no) {
		//넘어온 데이터를 DB에 전송해서 수정처리
		noticeService.update(dto, no);
		return "redirect:/notice/1";// 
	}
	@GetMapping("/notice/delete/{no}")
	public String delete(@PathVariable Long no) {
		noticeService.delete(no);
		return "redirect:/notice/1";
	}

}
