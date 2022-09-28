package com.consumo.practice.service;

import java.util.List;

import com.consumo.practice.dto.SalesmanRequestDTO;
import com.consumo.practice.dto.SalesmanResponseDTO;
import com.consumo.practice.exception.GeneralException;

public interface ISalesmanService {
	
	String guardarVendedor(SalesmanRequestDTO salesman) throws GeneralException;
	
	SalesmanResponseDTO getVendedorById(Long idSalesman) throws GeneralException;
	
	List<SalesmanResponseDTO> getAllVendedores();

}
