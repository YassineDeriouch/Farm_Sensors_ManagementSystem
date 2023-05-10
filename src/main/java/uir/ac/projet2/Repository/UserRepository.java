package uir.ac.projet2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uir.ac.projet2.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
