package com.shm.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductEntity {
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

	public ProductDto toDto() {
		ProductDto dto = new ProductDto();

		dto.setId(id);
		dto.setUserEmail(userEmail);
		dto.setCategoryId(categoryId);
		dto.setSold(sold);
		dto.setName(name);
		dto.setPrice(price);
		dto.setViewCount(viewCount);
		dto.setSellCount(sellCount);
		dto.setDescription(description);
		dto.setThumbnailUrl(thumbnailUrl);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);

		dto.setDetailUrlList(detailUrlList);

		return dto;
	}	
	
	
}
