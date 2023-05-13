package uir.ac.projet2.Controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uir.ac.projet2.Entity.Sensor;
import uir.ac.projet2.Service.SensorService;

import java.sql.Date;
import java.util.List;

/**
 * @author Yassine
 * @project Sensor_Sensors_ManagementSystem
 */
@CrossOrigin(origins = "*")
@RestController
@Data
@RequestMapping("Sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<Sensor> SaveSensor(@RequestBody Sensor sensor) {
        try {
            return new ResponseEntity<>(sensorService.saveSensor(sensor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * UPDATE SENSOR
     *
     * @param idSensor
     * @param sensor
     * @return
     */
    @CrossOrigin
    @PutMapping("/update/id")
    public ResponseEntity<Sensor> updateSensor(@RequestParam int idSensor, @RequestBody Sensor sensor) {
        try {
            return new ResponseEntity<>(sensorService.updateSensor(idSensor, sensor), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * GET SENSOR BY ID
     *
     * @param idSensor
     * @return
     */
    @CrossOrigin
    @GetMapping("/get/id")
    public ResponseEntity<Sensor> getSensorByID(@RequestParam int idSensor) {
        try {
            return new ResponseEntity<>(sensorService.getSensorByID(idSensor), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET SENSOR BY CATEGORY REFERENCE
     *
     * @param ref
     * @return
     */
    @CrossOrigin
    @GetMapping("/get/sensors/category/reference")
    public ResponseEntity<List<Sensor>> getSensorSensorsByID(@RequestParam String ref) {
        try {
            return new ResponseEntity<>(sensorService.getAllSensorsByCategory(ref), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * GET ALL SENSOR
     * @return
     */
    @CrossOrigin("*")
    @GetMapping("/get/all")
    public ResponseEntity<List<Sensor>> getAllSensors() {
        try {
            return new ResponseEntity<>(sensorService.getAllSensors(), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE ONE SENSOR
     *
     * @param idSensor
     * @return
     */
    @CrossOrigin
    @DeleteMapping("/delete/id")
    public ResponseEntity<Sensor> deleteSensorByID(@RequestParam int idSensor) {
        try {
            return new ResponseEntity<>(sensorService.deleteSensorByID(idSensor), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE ALL SENSORS
     *
     * @return
     */
    @CrossOrigin
    @DeleteMapping("/delete/all")
    public ResponseEntity<List<Sensor>> deleteAllSensors() {
        try {
            List<Sensor> sensor = sensorService.deleteAllSensors();
            return new ResponseEntity<>(sensor, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/search/farms/sensors")
    public ResponseEntity<List<Sensor>> searchByName(@RequestParam String nomSensor, @RequestParam int idFarm, @RequestParam Date date) {
        try {
            return new ResponseEntity<>(sensorService.searchBySensorName(nomSensor, idFarm, date), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
