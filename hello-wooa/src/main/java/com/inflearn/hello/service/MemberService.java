package com.inflearn.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.inflearn.hello.domain.Member;
import com.inflearn.hello.repository.MemberRepository;

@Transactional
public class MemberService {

	MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepositiry) {
		this.memberRepository = memberRepositiry;
	}

	/**
	 * 회원 가입
	 */
	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		// 동일 이름 중복회원으로 제거
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
