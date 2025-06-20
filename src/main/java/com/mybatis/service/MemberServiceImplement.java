package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.domain.Member;
import com.mybatis.mapper.MemberMapper;


@Service
public class MemberServiceImplement implements MemberService {
	@Autowired
	// 의존성 주입
	private MemberMapper memberMapper;

	@Override
	public void insert(Member member) throws Exception {
		memberMapper.insert(member);
	}

	@Override
	public Member selectByMemberNo(Member member) throws Exception {
		return memberMapper.selectByMemberNo(member);
	}

	@Override
	public void update(Member member) throws Exception {
		memberMapper.update(member);
	}

	@Override
	public void delete(Member member) throws Exception {
		memberMapper.delete(member);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return memberMapper.selectAll();
	}

}
