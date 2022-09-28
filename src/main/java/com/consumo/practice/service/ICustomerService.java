package com.consumo.practice.service;

import com.consumo.practice.dto.CustomerRequestDTO;
import com.consumo.practice.exception.GeneralException;

public interface ICustomerService {
	
	String guardarCliente(CustomerRequestDTO customer) throws GeneralException;
	
	/*SalesmanResponseDTO getClienteById(Long idSalesman) throws GeneralException;
	
	List<SalesmanResponseDTO> getAllClientes();

	String actualizarCliente(SalesmanRequestDTO salesman) throws GeneralException;
	
	String eliminarCliente(Long id) throws GeneralException;
*/
}
