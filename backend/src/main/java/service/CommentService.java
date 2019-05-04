package service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Comment;
import repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getCommentsByPostId(long postId) {
		List<Comment> comments = new ArrayList<Comment>();
		commentRepository.findByPostId(postId).forEach(comments::add);
		
		Collections.sort(comments, new Comparator<Comment>(){
			@Override
			public int compare(Comment o1, Comment o2) {				
				ZonedDateTime date1 = o1.getCreatedDate();
				ZonedDateTime date2 = o2.getCreatedDate();
			    
			    return date2.compareTo(date1);				
			}
		});
		
		return comments;
	}
	
	public void addComment(Comment comment) {
		comment.setCreatedDate(ZonedDateTime.now());
		commentRepository.save(comment);
	}
}
