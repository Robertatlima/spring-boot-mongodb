package com.springmongo.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmongo.mongodb.domain.Post;
import com.springmongo.mongodb.repositories.PostRepository;
import com.springmongo.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository userRepository;
	
	public List<Post> findAll(){
		return userRepository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Post insert(Post obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
}
