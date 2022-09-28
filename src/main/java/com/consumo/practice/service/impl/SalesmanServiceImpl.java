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
import com.consumo.practice.repository.SalesmanMapper;
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
			Salesman entidadSales = modelMapper.map(salesman, Salesman.class);
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
		
		if (idSalesman != null) {
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
		return Utils.mapList(array, SalesmanResponseDTO.class);
	}

	@Override
	public String actualizarVendedor(SalesmanRequestDTO salesmanDTO) throws GeneralException {
		String response;

		if (salesmanDTO.getIdSalesman() != null) {
			Salesman vendedor = salesmanMapper.getSalesmanById(salesmanDTO.getIdSalesman());

			if (!Objects.isNull(vendedor)) {
				if (!salesmanDTO.getNombre().isEmpty() && salesmanDTO.getCommission() != null
						&& salesmanDTO.getCity() != null && !salesmanDTO.getCity().equals("")) {

					Salesman entidadSales = modelMapper.map(salesmanDTO, Salesman.class);
					int respuesta = salesmanMapper.actualizarSalesman(entidadSales);

					if (respuesta == 1) {
						log.info("Edición correcta del vendedor: " + entidadSales.getNombre());
						response = "Se edito el vendedor " + entidadSales.getNombre();
					} else {
						log.info("Error al editar el vendedor");
						response = "Error al intentar editar el vendedor " + entidadSales.getNombre();
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
	public String eliminarVendedor(Long id) throws GeneralException {
		String response;
		
		if (id != null) {
			Salesman vendedor = salesmanMapper.getSalesmanById(id);
			if (!Objects.isNull(vendedor)) {
				int respuesta = salesmanMapper.eliminarSalesman(id);

				if (respuesta == 1) {
					log.info("Se elimino correctamente el vendedor: " + vendedor.getNombre());
					response = "Se elimino el vendedor " + vendedor.getNombre();
				} else {
					log.info("Error al eliminar el vendedor");
					response = "Error al intentar eliminar el vendedor " + vendedor.getNombre();
				}
			} else {
				throw new GeneralException("No se encontro el vendedor " + id, 404);
			}
		} else {
			throw new GeneralException("El id del vendedor es requerido", 400);
		}
		return response;
	}
	
}
