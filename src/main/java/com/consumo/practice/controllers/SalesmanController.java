package com.consumo.practice.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.dto.SalesmanRequestDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.service.ISalesmanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/salesman")
@Api(value = "SalesmanController", tags = {"Servicios REST para un vendedor"})
public class SalesmanController {

	@Autowired
	private ISalesmanService salesmanService;
	
	@PostMapping("/Guardar")
	@ApiOperation(value = "Mybatis insertar vendedor", notes = "Guarda un vendedor nuevo")
	public String guardaVededor(HttpServletResponse response, @RequestBody SalesmanRequestDTO salesmanDto) throws IOException {
		try {
			return salesmanService.guardarVendedor(salesmanDto);
		} catch (GeneralException e) {
			((HttpServletResponse) response).sendError(e.getCodigoError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            ((HttpServletResponse) response).sendError(500, e.getMessage());
            return null;
        }
	}
}
