package com.consumo.practice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.consumo.practice.dto.PostDto;
import com.consumo.practice.models.Comment;

public interface IComments {
	
	public ResponseEntity<List<Comment>> consumirService();

	public Comment[] consumirServiceConForEntity();
	
	public List<Comment> consumirServiceConForObject();
	
	public ResponseEntity<String> savePosts(PostDto post);
}
