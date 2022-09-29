package com.consumo.practice.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo para administrar a los clientes")
public class Customer {
	
	private Long idCustomer;
	private String nombre;
	private String ciudad;
	private Long grade;
	private Long salesmanId;
	
	// Campo para guardar el nombre del salesman
	private String salesman;
}
