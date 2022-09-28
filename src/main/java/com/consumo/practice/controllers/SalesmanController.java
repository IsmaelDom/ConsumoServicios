package com.consumo.practice.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.dto.SalesmanRequestDTO;
import com.consumo.practice.dto.SalesmanResponseDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.service.ISalesmanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
			(response).sendError(e.getCodigoError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return null;
        }
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Mybatis buscar vendedor por id", notes = "Buscar un vendedor por id")
	public SalesmanResponseDTO getVendedorById(HttpServletResponse response, 
			@ApiParam(name = "id", value = "id del vendedor", example = "1", required = true) @PathVariable long id) throws IOException {
		try {
			return salesmanService.getVendedorById(id);
		} catch (GeneralException e) {
			(response).sendError(e.getCodigoError(), e.getMessage());
            return null;
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return null;
        }
	}
	
	@GetMapping("getAll")
	@ApiOperation(value = "Mybatis consultar todos los vendedores", notes = "Consultar todos los vendedores")
	public List<SalesmanResponseDTO> getAllVendedor(HttpServletResponse response) throws IOException {
		try {
			return salesmanService.getAllVendedores();
		} catch (Exception e) {
            e.printStackTrace();
            (response).sendError(500, e.getMessage());
            return Collections.emptyList();
        }
	}
	
	@PutMapping("/Editar")
	@ApiOperation(value = "Mybatis editar vendedor", notes = "Edita un vendedor")
	public String editaVededor(HttpServletResponse response, @RequestBody SalesmanRequestDTO salesmanDto) throws IOException {
		try {
			return salesmanService.actualizarVendedores(salesmanDto);
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
