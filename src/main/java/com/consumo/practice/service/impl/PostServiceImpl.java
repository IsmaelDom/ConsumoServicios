package com.consumo.practice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumo.practice.dto.PostDto;
import com.consumo.practice.dto.PostRequestDTO;
import com.consumo.practice.dto.PostResponseDTO;
import com.consumo.practice.models.Post;
import com.consumo.practice.service.IPostService;

import lombok.extern.java.Log;

@Service
@Log
public class PostServiceImpl implements IPostService {
	
	@Autowired
    RestTemplate restTemplate;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<PostResponseDTO> listarPost() {
		ResponseEntity<Post[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", Post[].class);
		Post[] posts = response.getBody();
				
        List<Post> postList = Arrays.asList(posts);
        
        List<PostResponseDTO> dtoResponse = postList.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).collect(Collectors.toList());
        
		return dtoResponse;
	}

	@Override
	public PostResponseDTO guardarPost(PostDto post) {
		HttpHeaders headers = new HttpHeaders();
		Post postEntity = modelMapper.map(post, Post.class);
		
		log.info("Inicia el Consumo del servicio Post");

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Post> entity = new HttpEntity<Post>(postEntity, headers);

		ResponseEntity<PostResponseDTO> response = restTemplate.exchange(
		            "https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, entity, PostResponseDTO.class);
		    
		log.info("Finaliza el Consumo del servicio");
		return response.getBody();
	}

	@Override
	public PostRequestDTO editarPost(PostRequestDTO post, int id) {
		HttpHeaders headers = new HttpHeaders();
		Post postEntity = modelMapper.map(post, Post.class);

		log.info("Inicia el Consumo del servicio Post");

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Post> entity = new HttpEntity<Post>(postEntity, headers);

		ResponseEntity<Post> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.PUT, entity, Post.class);
		    
		log.info("Finaliza el Consumo del servicio");
		PostRequestDTO dto = modelMapper.map(response.getBody(), PostRequestDTO.class);
		return dto;
	}

	@Override
	public String eliminarPost(int idPost) {
		HttpHeaders headers = new HttpHeaders();
		String borrado = "Se elimino el Post";

		log.info("Inicia el Consumo del servicio Post");
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(borrado, headers);

		restTemplate.exchange(
				"https://jsonplaceholder.typicode.com/posts/" + idPost, HttpMethod.DELETE, entity, String.class);
		    
		log.info("Finaliza el Consumo del servicio");
		return borrado + " con id: " + idPost;
	}
}
