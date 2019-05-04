package service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Comment;
import model.Post;
import model.PostRequest;
import model.PostResponse;
import repository.CommentRepository;
import repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public PostResponse getAll(PostRequest postRequest) {		
		List<Post> posts = new ArrayList<Post>();
		
		// this can be cached to improve performance
		postRepository.findAll().forEach((item) -> {			
			List<Comment> comment = commentRepository.findByPostId(item.getId());
			int count = comment.size();
			item.setNumberOfComments(count);
			if (count > 0) {
				item.setLastCommentDate(comment.get(0).getCreatedDate());
			}
			posts.add(item);
		});
		
		Collections.sort(posts, new Comparator<Post>(){
			@Override
			public int compare(Post o1, Post o2) {				
				ZonedDateTime date1 = o1.getCreatedDate();
				ZonedDateTime date2 = o2.getCreatedDate();
				
				// not comparing time here according to the instruction
				if (date2.getYear() != date1.getYear()) 
			        return date2.getYear() - date1.getYear();
			    if (date2.getMonthValue() != date1.getMonthValue()) 
			        return date2.getMonthValue() - date1.getMonthValue();
			    if (date2.getDayOfMonth() != date1.getDayOfMonth())
			    	return date2.getDayOfMonth() - date1.getDayOfMonth();
			    
			    date1 = o1.getLastCommentDate();
			    date2 = o2.getLastCommentDate();
			    if (date1 == null && date2 == null)
			    	return 0;
			    if (date1 == null) {
			    	return 1;
			    }
			    if (date2 == null)
			    	return -1;
			    
			    return date2.compareTo(date1);				
			}
		});
		
		PostResponse response = new PostResponse();
		int totalPageNumber = posts.size() / postRequest.getNumberPerPage();
		
		if (posts.size() % postRequest.getNumberPerPage() > 0)
			totalPageNumber += 1;
		
		response.setTotalPageNumber(totalPageNumber);
		
		// pagination
		int startIndex = (postRequest.getPageNumber() - 1) * postRequest.getNumberPerPage();
		int endIndex = startIndex + postRequest.getNumberPerPage();
		
		if (endIndex < posts.size())
			response.setPosts(posts.subList(startIndex, endIndex));
		else if (startIndex <= posts.size())
			response.setPosts(posts.subList(startIndex, posts.size()));
		
		return response;
	}
	
	public Post getPost(long id) {
		return postRepository.findById(id).get();
	}

	public void addPost(Post post) {
		post.setCreatedDate(ZonedDateTime.now());
		postRepository.save(post);
	}
}
