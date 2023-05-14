package uir.ac.projet2.Entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yassine Deriouch
 * @project Farm_Sensors_ManagementSystem
 */

@Data
public class FarmDTO {
    private int idFarm;
    private String address;
    private String area;
    private String name;
    private double longitude;
    private double latitude;
    private String description;
    private List<String> sensorNames;

    // Constructor
    public FarmDTO(Farm farm) {
        this.idFarm = farm.getIdFarm();
        this.address = farm.getAddress();
        this.area = farm.getArea();
        this.name = farm.getName();
        this.longitude = farm.getLongitude();
        this.latitude = farm.getLatitude();
        this.description = farm.getDescription();
        this.sensorNames = farm.getSensorList().stream()
                .map(Sensor::getSensorName)
                .collect(Collectors.toList());
    }

    // Getters
    // Setters
}

