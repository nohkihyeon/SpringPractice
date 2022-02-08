package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

//@Repository
//public class MemberDao {
//	@Autowired
//	public SqlSession sqlSession;
//	
//	public void saveMember(Member member) {
//		sqlSession.insert("saveMember", member);
//	}
//}

@Mapper
public interface MemberDao {
//	@Autowired
//	public SqlSession sqlSession;
//	
//	public void saveMember(Member member) {
//		sqlSession.insert("saveMember", member);
//	}
	public void saveMember(Member member);

	public List<Member> getMemberList();
}
