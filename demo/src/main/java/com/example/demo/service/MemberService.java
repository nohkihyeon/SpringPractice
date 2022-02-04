package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;

@Service
@Transactional
public class MemberService {
	MemberDao memberDao;
	
	@Autowired
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public MemberResponse saveMember(MemberRequest req) {
		Member member = new Member(
				req.getId(),
				req.getPassword(),
				req.getName(),
				req.getGender(),
				LocalDate.of(req.getYear(), req.getMonth(), req.getDay()),
				req.getEmailId() + "@" + req.getEmailAddress(),
				req.getPhone(),
				req.getAddress()
				);
		
		memberDao.saveMember(member);

		return MemberResponse.of(member);
	}
}