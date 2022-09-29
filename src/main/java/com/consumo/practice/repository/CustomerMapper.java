package com.consumo.practice.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.consumo.practice.models.Customer;

@Mapper
public interface CustomerMapper {

	@Insert("INSERT INTO SYSTEM.CUSTOMER (CUST_NAME, CITY, GRADE, SALESMAN_ID) "
			+ "VALUES(#{nombre}, #{ciudad}, #{grade}, #{salesmanId})")
	int insert(Customer customer);
	
	@Update("UPDATE SYSTEM.CUSTOMER SET CUST_NAME = #{nombre}, CITY = #{ciudad}, GRADE = #{grade}, SALESMAN_ID = #{salesmanId}"
				+ " WHERE CUSTOMER_ID = #{idCustomer}")
	int actualizar(Customer customer);
	
	@Select("SELECT CUSTOMER_ID AS idCustomer, CUST_NAME AS nombre, CITY AS ciudad, GRADE, SALESMAN_ID as salesmanId "
			+ "FROM SYSTEM.CUSTOMER WHERE CUSTOMER_ID = #{id}")
	Customer getById(Long id);
	
	@Delete("DELETE FROM SYSTEM.CUSTOMER WHERE CUSTOMER_ID = #{id}")
	int eliminar(Long id);
}
