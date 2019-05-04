package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
