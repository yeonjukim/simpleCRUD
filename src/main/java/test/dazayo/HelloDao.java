package test.dazayo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloDao extends JpaRepository<Post, Integer> {

}
