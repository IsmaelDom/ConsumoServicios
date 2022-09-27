package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo DTO de entrada para Guardar un Vendedor")
public class SalesmanRequestDTO {
	
	@ApiModelProperty(notes = "Id del vendedor", name="Id", required=true, value="idSalesman", example = "0")
	private Long idSalesman;
	
	@ApiModelProperty(notes = "Nombre del vendedor", required=true, value="nombre", example = "Nombre")
	private String nombre;
	
	@ApiModelProperty(notes = "Ciudad del vendedor", required=true, value="city", example = "CDMX")
	private String city;
	
	@ApiModelProperty(notes = "Comision", required=true, value="commission", example = "90")
	private Long commission;
	
}
