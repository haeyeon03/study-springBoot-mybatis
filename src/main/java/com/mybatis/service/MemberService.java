package com.mybatis.service;

import java.util.List;

import com.mybatis.domain.Member;
import com.mybatis.domain.MemberAuth;
import com.mybatis.domain.MemberEmail;

public interface MemberService {
	
	/**
	 * 모든 회원 정보를 조회합니다.
	 *
	 * @return 회원 리스트
	 * @throws Exception 예외 발생 시
	 */
	public List<Member> selectAll() throws Exception;

	/**
	 * 회원 1명의 상세 정보를 조회합니다. (이메일 포함)
	 *
	 * @param member 조회할 회원 객체 (memberNo 사용)
	 * @return 회원 상세 정보
	 * @throws Exception 예외 발생 시
	 */
	public Member selectJoin(Member member) throws Exception;

	/**
	 * 회원 정보를 등록합니다.
	 *
	 * @param member 등록할 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	public void insert(Member member) throws Exception;

	/**
	 * 회원 이메일 정보를 등록합니다.
	 *
	 * @param memberEmail 등록할 이메일 객체
	 * @throws Exception 예외 발생 시
	 */
	void insertEmail(MemberEmail memberEmail) throws Exception;

	/**
	 * 회원 권한 정보를 등록합니다.
	 *
	 * @param memberAuth 등록할 권한 객체
	 * @throws Exception 예외 발생 시
	 */
	void insertAuth(MemberAuth memberAuth) throws Exception;

	/**
	 * 회원 정보를 수정합니다.
	 *
	 * @param member 수정할 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	public void update(Member member) throws Exception;

	/**
	 * 회원 정보를 삭제합니다.
	 *
	 * @param member 삭제할 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	public void delete(Member member) throws Exception;

	/**
	 * 회원 이메일 정보를 삭제합니다.
	 *
	 * @param member 대상 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	public void deleteEmail(Member member) throws Exception;

	/**
	 * 회원 권한 정보를 삭제합니다.
	 *
	 * @param member 대상 회원 객체
	 * @throws Exception 예외 발생 시
	 */
	public void deleteAuth(Member member) throws Exception;

}
