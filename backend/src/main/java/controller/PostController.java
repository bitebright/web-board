package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Post;
import model.PostRequest;
import model.PostResponse;
import service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
	public PostResponse getAll(@RequestBody PostRequest postRequest) {
		return postService.getAll(postRequest);
	}
	
	@GetMapping("/posts/{id}")
	public Post getPost(@PathVariable("id") long id) {
		return postService.getPost(id);
	}
	
	@PostMapping("/posts/add")
	public void AddPost(@RequestBody Post post) {
		postService.addPost(post);
	}
}
