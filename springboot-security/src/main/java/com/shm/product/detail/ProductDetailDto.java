package com.shm.product.detail;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetailDto {
	private int id;
	private int productId;
	private int sortOrder;
	private String imageUrl;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;

	public ProductDetailEntity toEntity() {
		ProductDetailEntity entity = new ProductDetailEntity();

		entity.setId(id);
		entity.setProductId(productId);
		entity.setSortOrder(sortOrder);
		entity.setImageUrl(imageUrl);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);

		return entity;
	}

}
