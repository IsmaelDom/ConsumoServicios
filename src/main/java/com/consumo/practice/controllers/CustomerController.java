package com.consumo.practice.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.dto.CustomerRequestDTO;
import com.consumo.practice.dto.CustomerResponseDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/customer")
@Api(value = "CustomerController", tags = {"Servicios REST para un Cliente"})
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/getAll")
	@ApiOperation(value = "Mybatis consultar todos los clientes", notes = "Consultar todos los clientes")
	public List<CustomerResponseDTO> getAllClientes(HttpServletResponse response) throws IOException {
		try {
			return customerService.getAllClientes();
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return Collections.emptyList();
        }
	}
	
	@PostMapping("/guardar")
	@ApiOperation(value = "Mybatis insertar cliente", notes = "Guarda un cliente nuevo")
	public String guardaCliente(HttpServletResponse response, @RequestBody CustomerRequestDTO customerDTO) throws IOException {
		try {
			return customerService.guardarCliente(customerDTO);
		} catch (GeneralException e) {
			(response).sendError(e.getCodeError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return null;
        }
	}
	
	@PutMapping("/editar")
	@ApiOperation(value = "Mybatis editar cliente", notes = "Edita un Cliente")
	public String editaVededor(HttpServletResponse response, @RequestBody CustomerRequestDTO customerDTO) throws IOException {
		try {
			return customerService.actualizarCliente(customerDTO);
		} catch (GeneralException e) {
			(response).sendError(e.getCodeError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return null;
        }
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Mybatis buscar cliente por id", notes = "Buscar un cliente por id")
	public CustomerRequestDTO getClienteById(HttpServletResponse response, 
			@ApiParam(name = "id", value = "id del cliente", example = "1", required = true) @PathVariable long id) throws IOException {
		try {
			return customerService.getClienteById(id);
		} catch (GeneralException e) {
			(response).sendError(e.getCodeError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return null;
        }
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Mybatis eliminar cliente por id", notes = "Eliminar un cliente por id")
	public String eliminarCliente(HttpServletResponse response,
			@ApiParam(name = "id", value = "id del cliente", example = "1", required = true) @PathVariable long id) throws IOException {
		try {
			return customerService.eliminarCliente(id);
		} catch (GeneralException e) {
			(response).sendError(e.getCodeError(), e.getMessage());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			(response).sendError(500, e.getMessage());
			return null;
		}
	}
}
