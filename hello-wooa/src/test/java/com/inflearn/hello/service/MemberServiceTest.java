package com.inflearn.hello.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inflearn.hello.domain.Member;
import com.inflearn.hello.repository.MemoryMemberRepository;

class MemberServiceTest {
	MemberService memberService;
	MemoryMemberRepository memoryMemberRepository;

	@BeforeEach
	void beforeEach() {
		memoryMemberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memoryMemberRepository);
	}

	@AfterEach
	void afterEach() {
		memoryMemberRepository.clearData();
	}

	@Test
	void join() {
		// given
		Member member = new Member();
		member.setName("hello");

		// when
		Long saveId = memberService.join(member);

		// then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	void duplicateJoin() {
		// given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
				
		// when
		memberService.join(member1);
		
		// test case 3
		// 테스트 성공
		IllegalStateException eMsg = assertThrows(IllegalStateException.class, ()->memberService.join(member2));
		assertThat(eMsg.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
//		// test case 2
//		// 테스트 실패
//		assertThrows(NullPointerException.class, ()->memberService.join(member2));
		
//		// test case 1
//		try {
//			memberService.join(member2);
//			// 테스트 실패 : 중복 체크가 되어야 하는데 안됐을 경우 메세지
//			fail("이름으로 중복 처리가 안됨");
//		} catch (Exception e) {
//			// 테스트 성공 : 동일한 에러 메세지가 나오면 성공
//			Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
		// than
	}

	@Test
	void findMembers() {

	}

	@Test
	void findOne() {

	}

}
