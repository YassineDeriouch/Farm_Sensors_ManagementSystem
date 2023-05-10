package uir.ac.projet2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uir.ac.projet2.Entity.SensorCategory;

@Repository
public interface SensorCategoryRepository extends JpaRepository<SensorCategory, Integer> {
}
