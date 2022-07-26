package com.consumo.practice.models;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo para crear un Post")
public class Post implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Identificador unico del Post", name="Id", required=true, value="Id")
	private Long id;
	
	@ApiModelProperty(notes = "Id del usuario", name="userId",required=true, value="userId")
	private Long userId;
	
	@ApiModelProperty(notes = "Titulo del Post", name="Titulo",required=true, value="title")
	private String title;
	
	@ApiModelProperty(notes = "Cuerpo del Post", name="Cuerpo",required=true, value="body")
	private String body;
	
}
