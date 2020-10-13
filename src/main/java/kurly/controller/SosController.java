package kurly.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.SosRequestDto;
import kurly.domain.dto.SosRequestUpdateDto;
import kurly.domain.dto.SosResponseDto;
import kurly.domain.dto.Sosdto;
import kurly.services.SosService;

@Controller
public class SosController {
	
	@Autowired
	private SosService service;
	
	//1대1문의 페이지 이동
	@GetMapping("/sos/{page}")
	public ModelAndView list(@PathVariable int page) {
		ModelAndView mv = service.findAll(page);
		
		// list 데이터는 impl에서 저장하였슴
		//이동할 페이지 주소
		mv.setViewName("/sos/list");
		
		return mv;
	}
	
	//글쓰기 페이지 이동
	@GetMapping("/sos/write")
	public String write() {
		return"/sos/write";
	}
	
	//글쓰기 처리
	@PostMapping("/sos/write")
	public String write(SosRequestDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.insert(dto);
		return"redirect:/sos/1";
	}
	
	//디테일 페이지
	@GetMapping("/sos/detail/{no}")
	public String detail(@PathVariable Long no, Model model) {
		Sosdto dto = service.findById(no);
		model.addAttribute("detail", dto);
		return"redirect:/sos/detail/1";
	}
	
	//삭제하기
	@GetMapping("/sos/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return"redirect:/sos/1";
	}
	
	
	//수정하기
	@PostMapping("/sos/edit")
	public String edit(SosRequestUpdateDto dto) {
		service.update(dto);
		return"redirect:/sos";
	}
	
	
	/*
	//리스트 페이지
	@GetMapping("/sos")
	public ModelAndView sos() {
		ModelAndView mv = new ModelAndView();
		List<Sosdto> dto = service.listAll();
		mv.addObject("noticeList", dto);
		mv.setViewName("/sos/list");
		return mv;
	}
	
	//글쓰기 페이지 이동
	@GetMapping("/sos/write")
	public String write() {
		return"/sos/write";
	}
	
	//글쓰기 처리
	@PostMapping("/sos/write")
	public String write(SosRequestDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.save(dto);
		return"redirect:/sos";
	}
	
	//디테일 페이지
	@GetMapping("/sos/detail/{no}")
	public String detail(@PathVariable Long no, Model model) {
		Sosdto dto = service.detail(no);
		model.addAttribute("detail", dto);
		return"/sos/detail";
	}
	
	//삭제하기
	@GetMapping("/sos/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return"redirect:/sos";
	}
	
	//수정하기
	@PostMapping("/sos/edit")
	public String edit(SosRequestUpdateDto update) {
		service.update(update);
		return"redirect:/sos";
	}
	*/

}
