package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	MemberService memberService;

	@RequestMapping
	public String showMemberForm() {
		return "member/member";
	}

	@RequestMapping(path = "/signUp")
	public String signUpMember(@ModelAttribute MemberRequest req, Model model) {
		MemberResponse member = memberService.saveMember(req);
		model.addAttribute("member", member);
		
		return "member/memberJoinFrom";
	}
}