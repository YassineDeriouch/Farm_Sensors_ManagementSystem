package uir.ac.projet2.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

/**
 * Created By Youssef on 10/05/2023
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */

@Entity
@Data
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSensor;

    @Column(name = "unit")
    private String Unit;

    @Column(name = "frequency")
    private double Frequency;

    @Column(name = "timestamp")
    private Date Timestamp;

    @Column(name = "value")
    private double Value;

    @ManyToOne
    @JoinColumn(name = "idCateg")
    private SensorCategory sensorCategory;


}
