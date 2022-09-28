package com.consumo.practice.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.consumo.practice.models.Customer;

@Mapper
public interface CustomerMapper {

	@Insert("INSERT INTO SYSTEM.CUSTOMER (CUST_NAME, CITY, GRADE, SALESMAN_ID) "
			+ "VALUES(#{nombre}, #{ciudad}, #{grade}, #{salesmanId})")
	Integer insert(Customer customer);
	
}
