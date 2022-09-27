package com.consumo.practice.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.consumo.practice.models.Salesman;

@Mapper
public interface SalesmanMapper {

	@Insert("INSERT INTO SYSTEM.SALESMAN (NOMBRE, CITY, COMMISSION) VALUES (#{nombre}, #{city}, #{commission})")
	@Options(useGeneratedKeys = false, keyColumn="SALESMAN_ID", keyProperty = "idSalesman")
	Integer insert(Salesman salesman);
}
