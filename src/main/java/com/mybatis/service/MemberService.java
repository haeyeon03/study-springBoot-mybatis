package com.mybatis.service;

import java.util.List;

import com.mybatis.domain.Member;

public interface MemberService {

	// 게시판 조회(All)
	List<Member> selectAll() throws Exception;

	// 게시판 조회(one)
	Member selectByMemberNo(Member member) throws Exception;

	// 게시판 삽입
	void insert(Member member) throws Exception;

	// 게시판 수정
	void update(Member member) throws Exception;

	// 게시판 삭제
	void delete(Member member) throws Exception;

}