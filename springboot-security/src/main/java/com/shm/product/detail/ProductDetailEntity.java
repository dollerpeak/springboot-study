package com.shm.product.detail;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetailEntity {
	private int id;
	private int productId;
	private int sortOrder;
	private String imageUrl;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;

	public ProductDetailDto toDto() {
		ProductDetailDto dto = new ProductDetailDto();

		dto.setId(id);
		dto.setProductId(productId);
		dto.setSortOrder(sortOrder);
		dto.setImageUrl(imageUrl);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);

		return dto;
	}

}
