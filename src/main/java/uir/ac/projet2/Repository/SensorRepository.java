package uir.ac.projet2.Repository;

import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uir.ac.projet2.Entity.Sensor;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    @Query(value = "SELECT s FROM Sensor s WHERE s.sensorCategory.Reference =:Reference", nativeQuery = false)
    List<Sensor> findSensorBySensorCategory_Reference(String Reference);

    @Query(value = "SELECT s FROM Sensor s JOIN s.farm f WHERE s.sensorName = :sensorName AND f.idFarm = :idFarm AND s.Timestamp = :date", nativeQuery = false)
    List<Sensor> findAllByFarm_nomSensorAndIdFarmAndTimestamp(String sensorName, int idFarm, Date date);


}
