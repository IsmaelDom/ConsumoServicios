package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo DTO de salida para un Cliente")
public class CustomerResponseDTO {

	@ApiModelProperty(notes = "Id del cliente", name="Id", required=true, value="idCustomer", example = "1", position = 0)
	private Long idCustomer;
	
	@ApiModelProperty(notes = "Nombre del cliente", name="Nombre", required=true, value="nombre", example = "Cliente 1", position = 1)
	private String nombre;
	
	@ApiModelProperty(notes = "Ciudad del cliente", name="Ciudad", required=true, value="ciudad", example = "Ciudad 1", position = 2)
	private String ciudad;
	
	@ApiModelProperty(notes = "Calificación del cliente", name="Grade", required=true, value="grade", example = "1", position = 3)
	private Long grade;
	
	@ApiModelProperty(notes = "Id del vendedor", name="SalesmanId", required=true, value="salesmanId", example = "2", position = 4)
	private Long salesmanId;
	
	@ApiModelProperty(notes = "Nombre del vendedor", name="Salesman", required=true, value="salesman", example = "Salesman", position = 5)
	private String salesman;
	
}
