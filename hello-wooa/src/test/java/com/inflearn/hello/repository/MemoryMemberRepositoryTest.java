package com.inflearn.hello.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.inflearn.hello.domain.Member;

public class MemoryMemberRepositoryTest {
	MemberRepository memberRepository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		((MemoryMemberRepository) memberRepository).clearData();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		memberRepository.save(member);

		Member result = memberRepository.findById(member.getId()).get();
		Assertions.assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		memberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberRepository.save(member2);

		Member result = memberRepository.findByName(member1.getName()).get();
		Assertions.assertThat(member1).isEqualTo(result);
	}	
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		memberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberRepository.save(member2);

		List<Member> result = memberRepository.findAll();
		Assertions.assertThat(result.size()).isEqualTo(2);
	}
	
}
