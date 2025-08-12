package com.shm.category;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryEntity {
	private int id;
	private String name;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;

	public CategoryDto toDto() {
		CategoryDto dto = new CategoryDto();

		dto.setId(id);
		dto.setName(name);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);

		return dto;
	}

}
