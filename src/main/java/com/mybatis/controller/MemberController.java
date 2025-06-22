package com.mybatis.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.domain.Member;
import com.mybatis.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "com.mybatis.mapper")
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	/**
	 * 전체 회원 목록을 조회하여 모델에 담아 목록 화면으로 이동합니다.
	 *
	 * @param model 뷰에 전달할 데이터 모델
	 * @throws Exception 예외 발생 시
	 */
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", memberService.selectAll());
	}

	/**
	 * 회원 등록 폼 화면 요청 처리 메서드
	 *
	 * @param member 폼 바인딩용 빈 객체
	 * @return 회원 등록 폼 뷰 이름
	 * @throws Exception 예외 발생 시
	 */
	@GetMapping("/registerForm")
	public String registerForm(Member member) throws Exception {
		log.info("registerForm");
		return "member/register";
	}

	/**
	 * 회원 등록 요청 처리 메서드
	 *
	 * @param member 등록할 회원 객체
	 * @param model 뷰에 전달할 데이터 모델
	 * @return 등록 성공 후 이동할 뷰 이름
	 * @throws Exception 예외 발생 시
	 */
	@PostMapping("/register")
	public String register(Member member, Model model) throws Exception {
		log.info("register");
		memberService.insert(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "member/success";
	}
	
	/**
	 * 회원 상세 조회 처리 메서드
	 *
	 * @param member 조회할 회원 객체 (memberNo 사용)
	 * @param model 뷰에 전달할 데이터 모델
	 * @throws Exception 예외 발생 시
	 */
	@GetMapping("/read")
	public void read(Member member, Model model) throws Exception {
		log.info("read");
		model.addAttribute(memberService.selectJoin(member));
	}

	/**
	 * 회원 삭제 요청 처리 메서드
	 *
	 * @param member 삭제할 회원 객체
	 * @param model 뷰에 전달할 데이터 모델
	 * @return 삭제 성공 후 이동할 뷰 이름
	 * @throws Exception 예외 발생 시
	 */
	@PostMapping("/remove")
	public String remove(Member member, Model model) throws Exception {
		log.info("remove");
		memberService.delete(member);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "member/success";
	}

	/**
	 * 회원 수정 폼 요청 처리 메서드
	 *
	 * @param member 수정할 회원 객체 (memberNo 사용)
	 * @param model 뷰에 전달할 데이터 모델
	 * @throws Exception 예외 발생 시
	 */
	@GetMapping("/modify")
	public void modifyForm(Member member, Model model) throws Exception {
		log.info("modifyForm");
		model.addAttribute(memberService.selectJoin(member));
	}

	/**
	 * 회원 수정 요청 처리 메서드
	 *
	 * @param member 수정할 회원 객체
	 * @param model 뷰에 전달할 데이터 모델
	 * @return 수정 성공 후 이동할 뷰 이름
	 * @throws Exception 예외 발생 시
	 */
	@PostMapping("/modify")
	public String modify(Member member, Model model) throws Exception {
		log.info("modify");
		memberService.update(member);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "member/success";
	}

}
