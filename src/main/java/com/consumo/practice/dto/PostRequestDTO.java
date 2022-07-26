package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo DTO de entrada para Editar un Post")
public class PostRequestDTO {

	@ApiModelProperty(notes = "Id del usuario", name="Id",required=true, value="userId", example = "23")
	private Long userId;
	
	@ApiModelProperty(notes = "Titulo del Post", required=true, value="title", example = "Titulo Ejemplo")
	private String title;
	
	@ApiModelProperty(notes = "Cuerpo del Post", required=true, example = "Cuerpo del Post como ejemplo")
	private String body;
	
}
