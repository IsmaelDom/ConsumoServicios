package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo DTO de entrada para Guardar un Cliente")
public class CustomerRequestDTO {

	@ApiModelProperty(notes = "Id del cliente", name="Id", required=true, value="idCustomer", example = "1")
	private Long idCustomer;
	
	@ApiModelProperty(notes = "Nombre del cliente", name="Nombre", required=true, value="nombre", example = "Cliente 1")
	private String nombre;
	
	@ApiModelProperty(notes = "Ciudad del cliente", name="Ciudad", required=true, value="ciudad", example = "Ciudad 1")
	private String ciudad;
	
	@ApiModelProperty(notes = "Calificación del cliente", name="Grade", required=true, value="grade", example = "1")
	private Long grade;
	
	@ApiModelProperty(notes = "Id del vendedor", name="SalesmanId", required=true, value="salesmanId", example = "2")
	private Long salesmanId;
	
}
