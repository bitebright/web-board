package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	@Query("SELECT c FROM Comment c WHERE c.postId = :postId ORDER BY c.createdDate DESC")
    public List<Comment> findByPostId(@Param("postId") long postId);
}
