package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public final class MemberController {
	MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

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

	@RequestMapping("/board")
	public String showMember() {
		return "member/memberBoard";
	}

	@RequestMapping(path = "/list")
	@ResponseBody
	public List<MemberResponse> findMember(
			@RequestParam(value = "searchString", required = false, defaultValue="general") String gradeString) {
		return memberService.getMemberList(gradeString);
	}

}
