package uir.ac.projet2.Repository;

import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uir.ac.projet2.Entity.Sensor;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    @Query(value = "SELECT s FROM Sensor s WHERE s.sensorCategory.Reference =:Reference", nativeQuery = false)
    List<Sensor> findSensorBySensorCategory_Reference(String Reference);
    
}
