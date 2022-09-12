package com.consumo.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.models.Entidad;
import com.consumo.practice.mybatis.mapper.EntidadMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(value = "EntidadController", tags = { "Servicios REST para las Entidades" })
public class EntidadController {

	@Autowired
	private EntidadMapper entidadMapper;

	@GetMapping("/findAllEntidades")
	@ApiOperation(value = "Mybatis Buscar todas las entidades", notes = "Busca todas las entidades y devuelve un arreglo")
	public List<Entidad> findAllEntidades() {
		return entidadMapper.findAllEntidades();
	}

	@GetMapping("{id}")
	@ApiOperation(value = "Mybatis Busca una entidad", notes = "Busca una entidad por medio de su id")
	Entidad getEntidad(
			@ApiParam(name = "id", value = "id de la entidad", example = "1", required = true) @PathVariable long id) {
		return entidadMapper.findById(id);
	}

}
