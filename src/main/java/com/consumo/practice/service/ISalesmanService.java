package com.consumo.practice.service;

import com.consumo.practice.dto.SalesmanRequestDTO;
import com.consumo.practice.exception.GeneralException;

public interface ISalesmanService {
	
	String guardarVendedor(SalesmanRequestDTO salesman) throws GeneralException;

}
