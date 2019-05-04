package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Comment;
import service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("/comments/bypost/{id}")
	public List<Comment> getComments(@PathVariable("id") long id) {
		return commentService.getCommentsByPostId(id);
	}
	
	@PostMapping("/comments/add")
	public void addComment(@RequestBody Comment comment) {
		commentService.addComment(comment);
	}
}
