package com.example.exam_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	/**
	 * @return
	 * 화면 최초 진입
	 */
	@GetMapping("/")
	public String Index() {
		return "index";
	}
	
	
	/**
	 * @return
	 * 회원가입 화면 진입
	 */
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	/**
	 * @return
	 * 로그인 화면 진입
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	/**
	 * @return
	 * 메인 화면 진입
	 */
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
}
