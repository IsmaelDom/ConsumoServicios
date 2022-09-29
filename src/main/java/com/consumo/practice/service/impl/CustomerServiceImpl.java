package com.consumo.practice.service.impl;

import java.util.Objects;

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

	@Override
	public String actualizarCliente(CustomerRequestDTO customerDto) throws GeneralException {
		String response;

		if (customerDto.getIdCustomer() != null) {
			Customer customer = customerMapper.getById(customerDto.getIdCustomer());

			if (!Objects.isNull(customer)) {
				if (!customerDto.getNombre().isEmpty() && customerDto.getGrade() != null
						&& customerDto.getSalesmanId()!= null && !customerDto.getCiudad().isEmpty()) {

					Customer entidadCliente = modelMapper.map(customerDto, Customer.class);
					int respuesta = customerMapper.actualizar(entidadCliente);

					if (respuesta == 1) {
						log.info("Edición correcta del cliente: " + entidadCliente.getNombre());
						response = "Se edito el cliente " + entidadCliente.getNombre();
					} else {
						log.info("Error al editar el cliente");
						response = "Error al intentar editar el cliente " + entidadCliente.getNombre();
					}
				} else {
					throw new GeneralException("Favor de ingresar los campos requeridos", 400);
				}
			} else {
				throw new GeneralException("No se encontro el vendedor ingresado", 404);
			}

		} else {
			throw new GeneralException("El id del vendedor es requerido", 400);
		}

		return response;
	}

	@Override
	public CustomerRequestDTO getClienteById(Long id) throws GeneralException {
		CustomerRequestDTO dto = new CustomerRequestDTO();
		
		if (id != null) {
			Customer customer = customerMapper.getById(id);
			
			if (customer != null) {
				dto = modelMapper.map(customer, CustomerRequestDTO.class);
			} else {
				log.warning("No se encontraron datos para el id " + id);
			}
		} else {
			throw new GeneralException("El id no puede estar vacio", 404);
		}
		return dto;
	}

}
