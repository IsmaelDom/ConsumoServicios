package com.consumo.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.models.Comment;
import com.consumo.practice.service.IComments;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "ConsumerController", tags ={"Servicios REST Comentarios de prueba"})
public class ConsumerController {
	
	 @Autowired
	 private IComments commentService;
	 
	@GetMapping
    @ApiOperation(
            value = "consumirApi",
            notes = "Consume la API de comentarios para prueba")
	public ResponseEntity<List<Comment>> consumirApi() {
		return commentService.consumirService();
    }
	
	@GetMapping(path="/comentariosConForEntity")
	@ApiOperation(
            value = "consumirApi",
            notes = "Consume la API de comentarios para prueba con ForEntity")
	public ResponseEntity<Comment[]> buscarComentariosConForEntity() {
		return new ResponseEntity<>(commentService.consumirServiceConForEntity(), HttpStatus.OK);
	}
	
	@GetMapping(path="/comentariosForObject", 
			produces = { MediaType.APPLICATION_JSON_VALUE,
					 	 MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(
            value = "consumirApi",
            notes = "Consume la API de comentarios para prueba con ForObject")
	public ResponseEntity<List<Comment>> buscarComentariosConForObject() {
		return new ResponseEntity<>(commentService.consumirServiceConForObject(), HttpStatus.OK);
	}
}
