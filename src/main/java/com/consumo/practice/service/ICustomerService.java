package com.consumo.practice.service;

import java.util.List;

import com.consumo.practice.dto.CustomerRequestDTO;
import com.consumo.practice.dto.CustomerResponseDTO;
import com.consumo.practice.exception.GeneralException;

public interface ICustomerService {
	
	List<CustomerResponseDTO> getAllClientes();
	
	String guardarCliente(CustomerRequestDTO customer) throws GeneralException;
	
	String actualizarCliente(CustomerRequestDTO customer) throws GeneralException;
	
	CustomerRequestDTO getClienteById(Long id) throws GeneralException;
	
	String eliminarCliente(Long id) throws GeneralException;

}
