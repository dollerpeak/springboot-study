package com.shm.user;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	private int id;
	private String name;
	private String password;
	private String role;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;
	
	public UserEntity toEntity() {
		UserEntity entity = new UserEntity();

		entity.setId(id);
		entity.setName(name);
		entity.setPassword(password);
		entity.setRole(role);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);

		return entity;
	}
}
