package com.consumo.practice.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo para administrar a los vendedores")
//@Entity
//@Table(name = "SALESMAN")
public class Salesman {

	//@Column(name = "salesman_id")
	private Long idSalesman;
	
	//@Column(name = "nombre")
	private String nombre;
	
	//@Column(name = "city")
	private String city;
	
	//@Column(name = "commission")
	private Long commission;
	
}
