package uir.ac.projet2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uir.ac.projet2.Entity.Farm;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer> {

    @Query(value = "SELECT f FROM Farm f where f.Name =:Name")
    Farm findFarmByName(String Name);
}
