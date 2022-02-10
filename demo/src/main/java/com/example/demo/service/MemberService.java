package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
				req.getAddress(),
				req.getGrade()
				);

		for(MultipartFile image : req.getFiles()) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
				String currentDateTime = simpleDateFormat.format(new Date());
				String originalName = image.getOriginalFilename();
				File dest = new File(currentDateTime + "_" + originalName);
				image.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		memberDao.saveMember(member);

		return MemberResponse.of(member);
	}

	public List<MemberResponse> getMemberList(String grade) {
		if(grade.equals("general")){
			return memberDao.getGeneralMemberList()
					.stream()
					.map(MemberResponse::of)
					.collect(Collectors.toList());
		}
		else if(grade.equals("admin")) {
			return memberDao.getAdminMemberList()
					.stream()
					.map(MemberResponse::of)
					.collect(Collectors.toList());
		}
		else if(grade.equals("all")) {
			return memberDao.getAllMemberList()
					.stream()
					.map(MemberResponse::of)
					.collect(Collectors.toList());
		}
		return null;
	}
}
