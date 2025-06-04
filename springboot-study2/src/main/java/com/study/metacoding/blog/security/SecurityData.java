//package com.study.metacoding.blog.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.study.metacoding.blog.dto.UserDto;
//
//@SuppressWarnings("serial")
//public class SecurityData implements UserDetails {
//	private UserDto userDto;
//	
//	public SecurityData(UserDto nUserDto) {
//		userDto = nUserDto;
//	}
//
//	@Override
//	public String getPassword() {
//		return userDto.getPassword();
//		//return null;
//	}
//
//	@Override
//	public String getUsername() {
//		return userDto.getName();
//		//return null;
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Collection<GrantedAuthority> auth = new ArrayList<>();
//		auth.add(new GrantedAuthority() {			
//			@Override
//			public String getAuthority() {
//				return "ROLE_" + userDto.getRole();
//				//return userDto.getRole();
//				//return null;
//			}
//		});
//		
//		return auth;
//		//return null;
//	}
//
//}
