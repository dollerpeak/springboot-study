package com.shm.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	private int id;
	private String userEmail;
	private int categoryId;
	private boolean sold;
	private String name;
	private int price;
	private int viewCount;
	private int sellCount;
	private String description;
	private String thumbnailUrl;
	private LocalDateTime frstRegDate;
	private String frstRegUserId;
	private LocalDateTime lastChgDate;
	private String lastChgUserId;

	private List<String> detailUrlList = new ArrayList<>();

	public ProductEntity toEntity() {
		ProductEntity entity = new ProductEntity();

		entity.setId(id);
		entity.setUserEmail(userEmail);
		entity.setCategoryId(categoryId);
		entity.setSold(sold);
		entity.setName(name);
		entity.setPrice(price);
		entity.setViewCount(viewCount);
		entity.setSellCount(sellCount);
		entity.setDescription(description);
		entity.setThumbnailUrl(thumbnailUrl);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);

		entity.setDetailUrlList(detailUrlList);

		return entity;
	}	

}
