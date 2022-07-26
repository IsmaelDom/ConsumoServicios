package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo DTO de entrada para crear un Post")
public class PostDto {
	
	@ApiModelProperty(position = 0, required=true, example = "Titulo")
	private String title;
	
	@ApiModelProperty(position = 1, required=true, example = "Cuerpo o contenido del Post")
	private String body;
	
	@ApiModelProperty(position = 2, required=true, example = "23")
	private int userId;
}
