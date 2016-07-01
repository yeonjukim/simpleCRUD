package test.dazayo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PostDao extends JpaRepository<Post, Integer> {

	List<Post> findBySubject(@Param("subject") String subject);
}
