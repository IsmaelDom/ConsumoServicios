package com.consumo.practice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumo.practice.dto.CustomerRequestDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.models.Customer;
import com.consumo.practice.repository.CustomerMapper;
import com.consumo.practice.service.ICustomerService;

import lombok.extern.java.Log;

@Service
@Log
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String guardarCliente(CustomerRequestDTO customerDto) throws GeneralException {
		String resp;

		if (!customerDto.getCiudad().isEmpty() && customerDto.getGrade() != null && customerDto.getSalesmanId() != null
				&& !customerDto.getNombre().isEmpty()) {

			Customer customer = modelMapper.map(customerDto, Customer.class);
			int respuesta = customerMapper.insert(customer);

			if (respuesta == 1) {
				log.info("Creación correcta del cliente: " + customer.getNombre());
				resp = "Se creo el cliente " + customer.getNombre();
			} else {
				log.info("Error al crear el cliente");
				resp = "Error al intentar crear el cliente " + customer.getNombre();
			}

		} else {
			throw new GeneralException("Favor de ingresar los campos requeridos", 400);
		}

		return resp;
	}


}
