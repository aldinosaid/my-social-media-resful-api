package mysocialmedia.restful.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mysocialmedia.restful.entity.Post;
import mysocialmedia.restful.entity.User;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findFirstByUserAndId(User user, Long id);
}
