package uir.ac.projet2.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uir.ac.projet2.Entity.Sensor;
import uir.ac.projet2.Entity.Sensor;
import uir.ac.projet2.Entity.SensorCategory;
import uir.ac.projet2.Repository.SensorRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Yassine
 * @project Sensor_Sensors_ManagementSystem
 */
@Service
@Data
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Sensor saveSensor(Sensor sensor) {
        sensor.setUnit(sensor.getUnit());
        sensor.setFrequency(sensor.getFrequency());

        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");        // automatically set current date in timestamp
        Date date = new Date(sqlDate.getTime());
        sensor.setTimestamp(date);

        sensor.setSensorCategory(sensor.getSensorCategory());
        Sensor savedSensor = sensorRepository.save(sensor);
        return modelMapper.map(savedSensor, Sensor.class);
    }

    /**
     * UPDATE SENSOR
     *
     * @param id
     * @param sensor
     * @return sensor object updatedSensor
     */
    @Transactional
    public Sensor updateSensor(int id, Sensor sensor) throws EntityNotFoundException {
        Optional<Sensor> sensorOptional = sensorRepository.findById(id);
        if (sensorOptional.isPresent()) {
            Sensor sensor1 = modelMapper.map(sensor, Sensor.class);
            sensor1.setIdSensor(id);
            Sensor updatedSensor = sensorRepository.save(sensor1);
            return modelMapper.map(updatedSensor, Sensor.class);
        } else {
            throw new EntityNotFoundException("sensor id= " + id + " not found");
        }
    }

    /**
     * GET ALL FARMS
     *
     * @return
     */
    @Transactional
    public List<Sensor> getAllSensors() throws EntityNotFoundException {
        return sensorRepository.findAll().stream().map(element -> modelMapper.map(element, Sensor.class))
                .collect(Collectors.toList());
    }

    /**
     * GET SENSOR BY ID
     *
     * @param id
     * @return sensor object
     */
    @Transactional
    public Sensor getSensorByID(int id) throws EntityNotFoundException {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        if (sensor.isPresent())
            return modelMapper.map(sensor, Sensor.class);
        else
            throw new EntityNotFoundException("Sensor id= " + id + " not found");
    }

    /**
     * GET ALL SENSORS BY CATEGORY
     *
     * @param reference
     * @return
     * @throws EntityNotFoundException
     */
    @Transactional
    public List<Sensor> getAllSensorsByCategory(String reference) throws EntityNotFoundException {
        //SensorCategory category =  new SensorCategory();

        List<Sensor> sensorList = sensorRepository.findSensorBySensorCategory_Reference(reference);
        if (!sensorList.isEmpty())
            return sensorList.stream().map(element -> modelMapper.map(element, Sensor.class))
                    .collect(Collectors.toList());
        else
            throw new EntityNotFoundException("category reference Not found");
    }

    /**
     * DELETE SENSOR BY ID
     *
     * @param id
     * @return SENSOR OBJECT
     * @throws EntityNotFoundException
     */
    @Transactional
    public Sensor deleteSensorByID(int id) throws EntityNotFoundException {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        if (sensor.isPresent()) {
            sensorRepository.deleteById(id);
            return modelMapper.map(sensor, Sensor.class);
        } else
            throw new EntityNotFoundException("Sensor id= " + id + " not found");
    }

    /**
     * DELETE ALL FARMS
     *
     * @return
     * @throws EntityNotFoundException
     */
    @Transactional
    public List<Sensor> deleteAllSensors() throws EntityNotFoundException {
        List<Sensor> sensors = sensorRepository.findAll();
        if (!sensors.isEmpty()) {
            sensorRepository.deleteAll();
            return sensors.stream().map(element -> modelMapper.map(element, Sensor.class))
                    .collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("NO sensor has been found !");
        }
    }
}
