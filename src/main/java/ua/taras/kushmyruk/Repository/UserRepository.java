package ua.taras.kushmyruk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.taras.kushmyruk.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);

}
