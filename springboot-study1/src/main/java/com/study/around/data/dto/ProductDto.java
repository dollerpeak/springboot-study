package com.study.around.data.dto;

import com.study.around.data.entity.ProductEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	@NotNull
	private String id;
	@NotNull
	private String name;
	@NotNull
	@Min(value=0)
	private int price;
	@NotNull
	@Min(value=0)
	private int stock;
	
	public ProductEntity toEntity() {
		ProductEntity productEntity = new ProductEntity(id, name, price, stock);
		
		return productEntity;
	}
}
