package mysocialmedia.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mysocialmedia.restful.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByToken(String token);

    Optional<User> findFisrtByUsername(String username);
}
