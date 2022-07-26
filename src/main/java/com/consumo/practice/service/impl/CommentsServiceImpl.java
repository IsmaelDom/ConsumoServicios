package com.consumo.practice.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumo.practice.dto.PostDto;
import com.consumo.practice.models.Comment;
import com.consumo.practice.service.IComments;

import lombok.extern.java.Log;

@Service
@Log
public class CommentsServiceImpl implements IComments {
	
	@Autowired
    RestTemplate restTemplate;

	@Override
	public ResponseEntity<List<Comment>> consumirService() {
		HttpHeaders headers = new HttpHeaders();

		log.info("Inicia el Consumo del servicio");

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Comment> entity = new HttpEntity<>(headers);

		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com/comments", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Comment>>() {
				});
		
		log.info("Finaliza el Consumo del servicio");
		
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}
	
	@Override
	public Comment[] consumirServiceConForEntity() {
		log.info("Inicia Busqueda Comentarios Con For Entity");

		/*restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
				request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				return execution.execute(request, body);
			}
		});*/

		ResponseEntity<Comment[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/comments", Comment[].class);

		log.info("Response: " + response.getBody());
		Comment[] comments = response.getBody();

		//List<Comment> object = response.getBody();

		return comments;
	}

	@Override
	public List<Comment> consumirServiceConForObject() {

		log.info("Inicia Busqueda Comentarios Con For Object");

		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
				request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				return execution.execute(request, body);
			}
		});

		List<Comment> response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments",
				List.class);

		//List<Comment> object = response;

		return response;
	}

	@Override
	public ResponseEntity<String> savePosts(PostDto post) {
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		//HttpEntity<Comment> entity = new HttpEntity<>(headers);

		/*ResponseEntity<List<Post>> response = restTemplate.postForObject(
				"https://jsonplaceholder.typicode.com/posts", post, Post.class);*/
		
		log.info("Finaliza el Consumo del servicio");
		
		//return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
		return null;
	}

}
