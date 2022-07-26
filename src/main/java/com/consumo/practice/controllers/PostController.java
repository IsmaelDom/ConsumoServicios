package com.consumo.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.practice.dto.PostDto;
import com.consumo.practice.dto.PostRequestDTO;
import com.consumo.practice.dto.PostResponseDTO;
import com.consumo.practice.service.IPostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(value = "PostController", tags = {"Servicios REST Post de prueba"})
public class PostController {
	
	@Autowired
	 private IPostService postService;
	
	@GetMapping(path="/obtenerPosts", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(
            value = "consumirApi Listar los Posts",
            notes = "Consume la API de Post para prueba, realiza un listado de post")
	public ResponseEntity<List<PostResponseDTO>> listarPosts() {
		return new ResponseEntity<>(postService.listarPost(), HttpStatus.OK);
	}

	@PostMapping(path="/guardarPost", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(
            value = "consumirApi Guardar",
            notes = "Consume la API de Post para prueba, realiza un Insert")
	public ResponseEntity<PostResponseDTO> guardarPosts(@RequestBody PostDto post) {
		return new ResponseEntity<>(postService.guardarPost(post), HttpStatus.CREATED);
	}
	
	@PutMapping(path="/editarPost/{id}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(
            value = "consumirApi Editar",
            notes = "Consume la API de Post para prueba, realiza un Update")
	public ResponseEntity<PostRequestDTO> editarPost(@RequestBody PostRequestDTO post, @ApiParam(name = "id", value = "id del Post", example = "1", required = true) @PathVariable int id) {
		return new ResponseEntity<>(postService.editarPost(post, id), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/eliminarPost/{id}")
	@ApiOperation(
            value = "consumirApi Eliminar",
            notes = "Consume la API de Post para prueba, realiza un Delete")
	public ResponseEntity<String> eliminarPost(@ApiParam(name = "id", value = "id del Post", example = "1", required = true) @PathVariable int id) {
		return new ResponseEntity<>(postService.eliminarPost(id), HttpStatus.OK);
	}
}
