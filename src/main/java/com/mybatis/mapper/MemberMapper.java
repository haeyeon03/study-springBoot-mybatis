package com.mybatis.mapper;

import java.util.List;


import com.mybatis.domain.Member;

public interface MemberMapper {

	// 게시판 조회(All)
	public List<Member> selectAll() throws Exception;

	// 게시판 조회(one)
	public Member selectByMemberNo(Member member) throws Exception;

	// 게시판 삽입
	public void insert(Member member) throws Exception;

	// 게시판 수정
	public void update(Member member) throws Exception;

	// 게시판 삭제
	public void delete(Member member) throws Exception;
}
