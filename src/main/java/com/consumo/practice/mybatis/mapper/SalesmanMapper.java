package com.consumo.practice.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.consumo.practice.models.Salesman;

@Mapper
public interface SalesmanMapper {

	@Insert("INSERT INTO SYSTEM.SALESMAN (NOMBRE, CITY, COMMISSION) VALUES (#{nombre}, #{city}, #{commission})")
	@Options(useGeneratedKeys = false, keyColumn="SALESMAN_ID", keyProperty = "idSalesman")
	Integer insert(Salesman salesman);
	
	@Select("SELECT SALESMAN_ID, NOMBRE, CITY, COMMISSION FROM SYSTEM.SALESMAN WHERE SALESMAN_ID = #{id}")
	@Results(value = {
			  @Result(property = "idSalesman", column = "SALESMAN_ID"),
			  @Result(property = "nombre", column = "NOMBRE"),
			  @Result(property = "city", column = "CITY"),
			  @Result(property = "commission", column = "COMMISSION")
			})
	Salesman getSalesmanById(Long id);
	
	@Select("SELECT * FROM SYSTEM.SALESMAN")
	@Results(value = {
			  @Result(property = "idSalesman", column = "SALESMAN_ID"),
			  @Result(property = "nombre", column = "NOMBRE"),
			  @Result(property = "city", column = "CITY"),
			  @Result(property = "commission", column = "COMMISSION")
			})
	List<Salesman> getAllVendedores();
	
}
