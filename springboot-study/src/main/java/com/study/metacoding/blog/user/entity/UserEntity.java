package com.study.metacoding.blog.user.entity;


import com.study.metacoding.blog.user.dto.UserDto;

import lombok.Data;

@Data
public class UserEntity {
	private int id;
	private String name;
	private String password;
	private String email;
	private String role; // USER, MANAGER, ADMIN
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	public UserDto toUserDto() {
		UserDto userDto = new UserDto();

		userDto.setId(id);
		userDto.setName(name);
		userDto.setPassword(password);
		userDto.setRole(role);
		userDto.setFrstRegDate(frstRegDate);
		userDto.setFrstRegUserId(frstRegUserId);
		userDto.setLastChgDate(lastChgDate);
		userDto.setLastChgUserId(lastChgUserId);

		return userDto;
	}
}
