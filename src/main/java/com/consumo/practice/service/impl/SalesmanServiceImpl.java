package com.consumo.practice.service.impl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumo.practice.dto.SalesmanRequestDTO;
import com.consumo.practice.dto.SalesmanResponseDTO;
import com.consumo.practice.exception.GeneralException;
import com.consumo.practice.models.Salesman;
import com.consumo.practice.mybatis.mapper.SalesmanMapper;
import com.consumo.practice.service.ISalesmanService;
import com.consumo.practice.util.Utils;

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

	@Override
	public SalesmanResponseDTO getVendedorById(Long idSalesman) throws GeneralException {
		SalesmanResponseDTO dto = new SalesmanResponseDTO();
		
		if (idSalesman != null && !Objects.isNull(idSalesman)) {
			Salesman salesman = salesmanMapper.getSalesmanById(idSalesman);
			
			if (salesman != null) {
				dto = modelMapper.map(salesman, SalesmanResponseDTO.class);
			} else {
				log.warning("No se encontraron datos para el id " + idSalesman);
			}
		} else {
			throw new GeneralException("El id no puede estar vacio", 404);
		}
		return dto;
	}

	@Override
	public List<SalesmanResponseDTO> getAllVendedores() {
		List<Salesman> array = salesmanMapper.getAllVendedores();
		List<SalesmanResponseDTO> arrayDto = Utils.mapList(array, SalesmanResponseDTO.class);
		
		return arrayDto;
	}
	
}
