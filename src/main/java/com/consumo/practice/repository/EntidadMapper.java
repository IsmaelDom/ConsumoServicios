package com.consumo.practice.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.consumo.practice.models.Entidad;

@Mapper
public interface EntidadMapper {
	
	@Select("SELECT ID, DESCRIPTION FROM SYSTEM.\"cat_entidades\" WHERE ID = #{id}")
	Entidad findById(@Param("id") long id);
	
	@Select("SELECT * FROM SYSTEM.\"cat_entidades\"")
	List<Entidad> findAllEntidades();
	
}
