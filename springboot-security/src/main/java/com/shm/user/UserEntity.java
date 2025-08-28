package com.shm.user;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserEntity {
	private String email;
	private String name;
	private String password;
	private String role;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;
	
	private int totalOrderCount;
	private int totalOrderMoney;
	private int totalReturnCount;

	public UserDto toDto() {
		UserDto dto = new UserDto();

		dto.setEmail(email);
		dto.setName(name);
		dto.setPassword(password);
		dto.setRole(role);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);
		
		dto.setTotalOrderCount(totalOrderCount);
		dto.setTotalOrderMoney(totalOrderMoney);
		dto.setTotalReturnCount(totalReturnCount);

		return dto;
	}
}
