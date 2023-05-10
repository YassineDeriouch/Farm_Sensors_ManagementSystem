package uir.ac.projet2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uir.ac.projet2.Entity.Farm;

@Repository
public interface FarmRepository  extends JpaRepository<Farm, Integer> {
}
