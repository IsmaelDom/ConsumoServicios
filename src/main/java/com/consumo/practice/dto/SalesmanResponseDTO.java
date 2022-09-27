package com.consumo.practice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo DTO de respuesta para un Vendedor")
public class SalesmanResponseDTO {
	
	@ApiModelProperty(position = 0, required=true, example = "23")
	private Long idSalesman;
	
	@ApiModelProperty(position = 1, required=true, example = "Vendedor 1")
	private String nombre;
	
	@ApiModelProperty(position = 3, required=true, example = "CDMX")
	private String city;
	
	@ApiModelProperty(position = 2, required=true, example = "230")
	private Long commission;
}
