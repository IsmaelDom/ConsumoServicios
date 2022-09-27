package com.consumo.practice.models;

import javax.persistence.Column;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Modelo para administrar a los clientes")
//@Table(name = "CUSTOMER")
public class Customer {
	
	@Column(name = "customer_id")
	private Long idCustomer;
	
	@Column(name = "cust_name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "grade")
	private Long grade;
	
	@Column(name = "salesman_id")
	private Long salesmanId;
}
