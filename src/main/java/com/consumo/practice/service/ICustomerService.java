package com.consumo.practice.service;

import com.consumo.practice.dto.CustomerRequestDTO;
import com.consumo.practice.exception.GeneralException;

public interface ICustomerService {
	
	String guardarCliente(CustomerRequestDTO customer) throws GeneralException;
	
	String actualizarCliente(CustomerRequestDTO customer) throws GeneralException;
	
	CustomerRequestDTO getClienteById(Long id) throws GeneralException;
	
	String eliminarCliente(Long id) throws GeneralException;
	
	//List<SalesmanResponseDTO> getAllClientes();
}
