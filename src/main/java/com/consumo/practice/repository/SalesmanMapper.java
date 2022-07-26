package com.consumo.practice.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	@Update("UPDATE SYSTEM.SALESMAN SET NOMBRE = #{nombre}, CITY = #{city}, COMMISSION = #{commission} WHERE SALESMAN_ID = #{idSalesman}")
	Integer actualizarSalesman(Salesman salesman);
	
	@Delete("DELETE FROM SYSTEM.SALESMAN WHERE SALESMAN_ID = #{id}")
	Integer eliminarSalesman(Long id);
}
