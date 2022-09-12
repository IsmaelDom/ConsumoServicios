package com.consumo.practice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo para consultar una entidad")
public class Entidad {
	
	@ApiModelProperty(notes = "Identificador unico de la entidad", name="Id", required=true, value="Id")
	private Long id;
	
	@ApiModelProperty(notes = "Descripción", name="description",required=true, value="Entidad")
	private String description;
	
}
