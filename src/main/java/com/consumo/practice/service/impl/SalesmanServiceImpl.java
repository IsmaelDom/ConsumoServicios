package com.consumo.practice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumo.practice.dto.SalesmanRequestDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.models.Salesman;
import com.consumo.practice.mybatis.mapper.SalesmanMapper;
import com.consumo.practice.service.ISalesmanService;

import lombok.extern.java.Log;

@Service
@Log
public class SalesmanServiceImpl implements ISalesmanService {
	
	@Autowired
	private SalesmanMapper salesmanMapper;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String guardarVendedor(SalesmanRequestDTO salesman) throws GeneralException {
		String resp;
		
		if (!salesman.getCity().isEmpty() && !salesman.getNombre().isEmpty() && salesman.getCommission() != null) {
			Salesman entidadSales = new Salesman();
			
			entidadSales = modelMapper.map(salesman, Salesman.class);
			int respuesta = salesmanMapper.insert(entidadSales);
			
			if (respuesta == 1) {
				log.info("Creación correcta del vendedor: " + entidadSales.getNombre());
				resp = "Se creo el vendedor " + entidadSales.getNombre();
			} else {
				log.info("Error al crear el vendedor");
				resp = "Error al intentar crear el vendedor "+ entidadSales.getNombre();
			}
			
		} else {
			throw new GeneralException("Favor de ingresar los campos requeridos", 400);
		}
		
		return resp;
	}

}
