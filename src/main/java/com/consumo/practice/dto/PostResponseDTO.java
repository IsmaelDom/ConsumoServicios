package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo DTO de respuesta para un Post")
public class PostResponseDTO {
	
	@ApiModelProperty(position = 0, required=true, example = "23")
	private Long id;
	
	@ApiModelProperty(position = 3, required=true, example = "12")
	private Long userId;
	
	@ApiModelProperty(position = 1, required=true, example = "Malesuada Pellentesque")
	private String title;
	
	@ApiModelProperty(position = 2, required=true, example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.")
	private String body;
}
