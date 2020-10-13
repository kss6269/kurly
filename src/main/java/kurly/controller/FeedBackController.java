package kurly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kurly.domain.dto.FeedBackDto;
import kurly.domain.dto.FeedBackRequestDto;
import kurly.domain.dto.FeedBackUpdateDto;
import kurly.services.FeedBackService;

@Controller
public class FeedBackController {
	
	@Autowired
	private FeedBackService service;
	
	@GetMapping("/feedback")
	public String list(Model model) {
		List<FeedBackDto> list = service.findAll();
		model.addAttribute("noticeList", list);
		return "/feedback/list";
	}
	
	@GetMapping("/feedback/write")
	public String write() {
		return "/feedback/write";
	}
	
	@PostMapping("/feedback/write")
	public String write(FeedBackRequestDto dto,HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		dto.setWriter("김성수");
		service.save(dto);
		return "redirect:/feedback";
	}
	
	@GetMapping("/feedback/detail/{no}")
	public String detail(@PathVariable Long no, Model model) {
		FeedBackDto dto = service.findById(no);
		model.addAttribute("detail", dto);
		return"/feedback/detail";
	}
	
	@PostMapping("/feedback/edit")
	public String edit(FeedBackUpdateDto dto) {
		service.update(dto);
		return "redirect:/feedback/"+dto.getNo();
	}
	
	@GetMapping("/feedback/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return "redirect:/feedback";
	}

}
