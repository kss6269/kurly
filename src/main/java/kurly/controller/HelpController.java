package kurly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.HelpDto;
import kurly.domain.dto.HelpRequestDto;
import kurly.domain.dto.HelpResponseDto;
import kurly.services.HelpService;

@Controller
public class HelpController {
	
	@Autowired
	private HelpService service;
	
	//리스트페이지
	@GetMapping("/help")
	public ModelAndView list() {
		List<HelpDto> list = service.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/help/list");
		mv.addObject("noticeList", list);
		return mv;
	}
	
	//글쓰기페이지
	@GetMapping("/help/write")
	public String write() {
		return"/help/write";
	}
	
	//글쓰기처리
	@PostMapping("/help/write")
	public String write(HelpRequestDto dto,HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		dto.setWriter("김성수");
		service.write(dto);
		return"redirect:/help";
	}
	
	//디테일 페이지
	@GetMapping("/help/detail/{no}")
	public ModelAndView detail(@PathVariable Long no) {
		HelpDto dto = service.detail(no);
		ModelAndView mv = new ModelAndView("/help/detail");
		mv.addObject("detail", dto);
		return mv;
	}
	
	//수정페이지
	@PostMapping("/help/edit")
	public String edit(HelpResponseDto dto) {
		service.edit(dto);
		return "redirect:/help";
	}
	
	//삭제
	@GetMapping("/help/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return "redirect:/help";
	}

}
