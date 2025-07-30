package com.example.exam_jpa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.exam_jpa.dto.UserDTO;
import com.example.exam_jpa.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	/**
	 * @param userDTO
	 * @return
	 * 회원가입 처리
	 */
	@PostMapping("/joinForm")
	public String joinForm(UserDTO userDTO) {
		userService.save(userDTO);
		return "index";
	}
	
	/**
	 * @param userDTO
	 * @param session
	 * @param model
	 * @return
	 * 로그인 처리
	 */
	@PostMapping("/loginForm")
	public String loginForm(UserDTO userDTO, HttpSession session, Model model) {
		
		UserDTO result = userService.login(userDTO);
		
		if(result != null) {
			List<UserDTO> userList = userService.findAll();
			model.addAttribute("userList", userList);
			session.setAttribute("userid", result.getUserid());
			return "main";
		}else {
			model.addAttribute("msg", "아이디 혹은 비밀번호가 옳바르지 않습니다.");
			return "login";
		}
	}
	
	/**
	 * @param session
	 * @return
	 * 로그아웃 처리
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		String session_id = (String) session.getAttribute("userid");
		session.removeAttribute(session_id);
		session.invalidate();
		return "login";
	}
	
	/**
	 * @param userid
	 * @param model
	 * @param session
	 * @return
	 * 사용자 상세 보기 처리
	 */
	@GetMapping("/detail/{userid}")
	public String userDetail(@PathVariable String userid, Model model, HttpSession session) {
		String s_id = (String) session.getAttribute("userid");
		
		if(userid.equals(s_id)) {
			UserDTO userDTO = userService.detail(userid);
			model.addAttribute("user", userDTO);
			return "userDetail";
		}else {
			return "main";
		}
	}
	
	/**
	 * @param userDTO
	 * @param model
	 * @return
	 * 사용자 수정
	 */
	@PostMapping("/updateForm")
	public String updateForm(UserDTO userDTO, Model model) {
		userService.update(userDTO);
		List<UserDTO> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "main";
	}
	
	
}
