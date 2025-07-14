package com.shm.common.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shm.user.UserDto;

import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@ToString
public class CustomUserDetails implements UserDetails {
	// dto
	private UserDto userDto;

//	// 필수정보
//	private String email;
//	private String name;
//	private String password;
//	private String role;

	// dto
	public CustomUserDetails(UserDto userDto) {
		this.userDto = userDto;
	}

	@Override
	public String getUsername() {
		return userDto.getName();
	}

	@Override
	public String getPassword() {
		return userDto.getPassword();
	}

//	// 필수정보
//	public CustomUserDetails(String email, String name, String password, String role) {
//		this.email = email;
//		this.name = name;
//		this.password = password;
//		this.role = role;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		return name;
//	}

	// 권한 없이 인증만
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

//	// 아래는 모두 true로 해야 하는데 default로 true로 정의되어 있음
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}

}
