package kurly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.dto.MemberLoginDto;
import kurly.domain.dto.MemberRequestDto;
import kurly.services.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	//회원가입 페이지 이동
	@GetMapping("/member/join")
	public String join() {
		return"/member/join";
	}
	
	//회원가입 처리
	@PostMapping("/member/join")
	public ModelAndView join(MemberRequestDto dto) {
		memberService.join(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", dto.getName());
		mv.setViewName("/member/login");
		return mv;
	}
	
	/*
	@PostMapping("/member/join")
	public ModelAndView join(MemberRequestDto dto ) {
		//웹페이지에서 회원정보 받고
		//System.out.println(dto);
		memberService.addMember(dto);
		
		ModelAndView mv=new ModelAndView("/member/login");
		mv.addObject("userName", dto.getName());
		return mv;
	}
	*/
	
	//로그인 페이지 이동
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	//로그인처리
	@PostMapping("/member/login")
	public ModelAndView login(MemberLoginDto dto, HttpSession session) {
		MemberLoginDto login = memberService.login(dto);
		ModelAndView mv = new ModelAndView();
		if(login==null) {
			mv.addObject("log_msg","아이디나 패스워드가 일치하지 않습니다.");
			mv.setViewName("/member/login");
		}else {
			session.setAttribute("logInfo", login);
			mv.setViewName("redirect:/");
		}
			
		return mv;
	}
	
	//로그아웃 처리
	@GetMapping("/member/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("logInfo");
		return"redirect:/";
	}
	
	
	/*
	@PostMapping("/member/login")
	public ModelAndView login(MemberLoginDto dto, HttpSession session) {
		MemberLoginDto logMember= memberService.login(dto);
		ModelAndView mv=new ModelAndView();
		if(logMember==null) {
			//로그인실패
			//다시로그인페이지로
			mv.addObject("log_msg", "아이디나 패스워드가 일치하지 않습니다.");
			mv.setViewName("/member/login");
		}else {
			session.setAttribute("logInfo", logMember);
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	*/
	
	/*
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("logInfo");
		return "redirect:/";
	}
	*/
}
