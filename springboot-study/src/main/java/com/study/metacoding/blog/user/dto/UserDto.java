package com.study.metacoding.blog.user.dto;


import com.study.metacoding.blog.user.entity.UserEntity;

import lombok.Data;

@Data
public class UserDto {
	private int id;
	private String name;
	private String password;
	private String email;
	private String role; // USER, MANAGER, ADMIN
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	public UserEntity toUserEntity() {
		UserEntity userEntity = new UserEntity();

		userEntity.setId(id);
		userEntity.setName(name);
		userEntity.setPassword(password);
		userEntity.setEmail(email);
		userEntity.setRole(role);
		userEntity.setFrstRegDate(frstRegDate);
		userEntity.setFrstRegUserId(frstRegUserId);
		userEntity.setLastChgDate(lastChgDate);
		userEntity.setLastChgUserId(lastChgUserId);

		return userEntity;
	}

}
