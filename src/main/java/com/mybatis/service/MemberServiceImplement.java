package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.domain.Member;
import com.mybatis.domain.MemberAuth;
import com.mybatis.domain.MemberEmail;
import com.mybatis.mapper.MemberMapper;

@Service
public class MemberServiceImplement implements MemberService {

	@Autowired
	/* MemberMapper를 통해 DB에 접근 (의존성 주입) */
	private MemberMapper memberMapper;

	/**
	 * 회원 정보 및 이메일, 권한을 등록합니다.
	 *
	 * @param member 등록할 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void insert(Member member) throws Exception {
		memberMapper.insert(member);

		List<MemberEmail> emailList = member.getEmailList();

		if (emailList != null) {
			for (MemberEmail emailItem : emailList) {
				MemberEmail memberEmail = new MemberEmail();
				memberEmail.setNo(member.getMemberNo());

				String email = emailItem.getEmail();
				if (email == null || email.trim().isEmpty()) {
					email = "-";
				}
				memberEmail.setEmail(email);
				memberMapper.insertEmail(memberEmail);

				MemberAuth memberAuth = new MemberAuth();
				memberAuth.setNo(member.getMemberNo());
				memberAuth.setAuth("ROLE_USER");

				memberMapper.insertAuth(memberAuth);
			}
		}
	}

	/**
	 * 이메일 정보를 등록합니다.
	 *
	 * @param memberEmail 등록할 이메일 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void insertEmail(MemberEmail memberEmail) throws Exception {
		memberMapper.insertEmail(memberEmail);
	}

	/**
	 * 권한 정보를 등록합니다.
	 *
	 * @param memberAuth 등록할 권한 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void insertAuth(MemberAuth memberAuth) throws Exception {
		memberMapper.insertAuth(memberAuth);
	}

	/**
	 * 모든 회원 정보를 조회합니다.
	 *
	 * @return 회원 리스트
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public List<Member> selectAll() throws Exception {
		return memberMapper.selectAll();
	}

	/**
	 * 회원의 상세 정보를 조회합니다. (이메일, 권한 포함)
	 *
	 * @param member 조회할 회원 객체 (memberNo 사용)
	 * @return 회원 상세 정보
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public Member selectJoin(Member member) throws Exception {
		return memberMapper.selectJoin(member);
	}

	/**
	 * 회원 정보를 수정하고, 이메일 및 권한을 갱신합니다.
	 *
	 * @param member 수정할 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void update(Member member) throws Exception {
		memberMapper.update(member);

		deleteEmail(member);
		deleteAuth(member);

		List<MemberEmail> emailList = member.getEmailList();
		for (MemberEmail memberEmail : emailList) {
			String email = memberEmail.getEmail();
			if (email == null || email.trim().isEmpty()) {
				continue;
			}
			memberEmail.setNo(member.getMemberNo());
			memberMapper.insertEmail(memberEmail);
		}

		List<MemberAuth> authList = member.getAuthList();
		for (MemberAuth memberAuth : authList) {
			String auth = memberAuth.getAuth();
			if (auth == null || auth.trim().isEmpty()) {
				continue;
			}
			memberAuth.setNo(member.getMemberNo());
			memberMapper.insertAuth(memberAuth);
		}
	}

	/**
	 * 회원 정보를 삭제합니다. (이메일, 권한 포함)
	 *
	 * @param member 삭제할 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void delete(Member member) throws Exception {
		deleteEmail(member);
		deleteAuth(member);
		memberMapper.delete(member);
	}

	/**
	 * 회원의 이메일 정보를 삭제합니다.
	 *
	 * @param member 대상 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void deleteEmail(Member member) throws Exception {
		memberMapper.deleteEmail(member);
	}

	/**
	 * 회원의 권한 정보를 삭제합니다.
	 *
	 * @param member 대상 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	@Override
	public void deleteAuth(Member member) throws Exception {
		memberMapper.deleteAuth(member);
	}
}
