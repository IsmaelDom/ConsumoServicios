package com.consumo.practice.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.dto.CustomerRequestDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customer")
@Api(value = "CustomerController", tags = {"Servicios REST para un cliente"})
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/guardar")
	@ApiOperation(value = "Mybatis insertar cliente", notes = "Guarda un cliente nuevo")
	public String guardaCliente(HttpServletResponse response, @RequestBody CustomerRequestDTO customerDTO) throws IOException {
		try {
			return customerService.guardarCliente(customerDTO);
		} catch (GeneralException e) {
			(response).sendError(e.getCodigoError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return null;
        }
	}
}
