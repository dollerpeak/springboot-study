package com.shm.product;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductEntity {
	private int id;
	private int userId;
	private int categoryId;
	private boolean sold;
	private String name;
	private int price;
	private int viewCount;
	private int sellCount;
	private String desc;
	private String thumbnailUrl;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;

	public ProductDto toDto() {
		ProductDto dto = new ProductDto();

		dto.setId(id);
		dto.setUserId(userId);
		dto.setCategoryId(categoryId);
		dto.setSold(sold);
		dto.setName(name);
		dto.setPrice(price);
		dto.setViewCount(viewCount);
		dto.setSellCount(sellCount);
		dto.setDesc(desc);
		dto.setThumbnailUrl(thumbnailUrl);		
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);

		return dto;
	}	
	
	
}
