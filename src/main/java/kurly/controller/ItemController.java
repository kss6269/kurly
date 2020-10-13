package kurly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.ItemDto;
import kurly.domain.dto.ItemRequestDto;
import kurly.domain.dto.ItemRequestUpdate;
import kurly.services.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	//리스트
	@GetMapping("/item")
	public String list(Model model) {
		List<ItemDto> list = service.selectAll();
		model.addAttribute("noticeList", list);
		return "/item/list";
	}
	
	//글쓰기 페이지
	@GetMapping("/item/write")
	public String write() {
		return "/item/write";
	}
	
	//글쓰기 처리
	@PostMapping("/item/write")
	public String write(ItemRequestDto dto,HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		dto.setWriter("test");
		service.save(dto);
		return "redirect:/item";
	}
	
	//디테일
	@GetMapping("/item/detail/{no}")
	public ModelAndView detail(@PathVariable Long no) {
		ItemDto dto = service.findById(no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", dto);
		mv.setViewName("/item/detail");
		//model.addAttribute("detail", dto);
		return mv;
	}
	
	//수정
	@PostMapping("/item/edit")
	public String edit(ItemRequestUpdate dto) {
		service.update(dto);
		return "redirect:/item";
	}
	
	//삭제
	@GetMapping("/item/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return "redirect:/item";
	}

}
