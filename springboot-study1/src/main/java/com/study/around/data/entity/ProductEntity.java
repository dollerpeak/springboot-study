package com.study.around.data.entity;

import com.study.around.data.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "product")
public class ProductEntity {
//	@Id
	String id;
	String name;
	Integer price;
	Integer stock;

	public ProductDto toDto() {
		ProductDto productDto = new ProductDto(id, name, price, stock);

		return productDto;
	}
}
