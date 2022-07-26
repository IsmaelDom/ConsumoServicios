package com.consumo.practice.service;

import java.util.List;

import com.consumo.practice.dto.PostDto;
import com.consumo.practice.dto.PostRequestDTO;
import com.consumo.practice.dto.PostResponseDTO;

public interface IPostService {
	
	List<PostResponseDTO> listarPost();

	PostResponseDTO guardarPost(PostDto post);
	
	PostRequestDTO editarPost(PostRequestDTO post, int id);
	
	String eliminarPost(int idPost);
}
