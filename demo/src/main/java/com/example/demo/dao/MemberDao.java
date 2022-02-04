package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public class MemberDao {
   @Autowired
   public SqlSession sqlSession;
   
   public void saveMember(Member member){
      sqlSession.insert("saveMember",member);
   }
}