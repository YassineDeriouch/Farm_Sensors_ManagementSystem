package uir.ac.projet2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

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
    @Column(name = "idSensor")
    private int idSensor;

    @Column(name = "unit")
    private String Unit;

    @Column(name = "frequency")
    private double Frequency;

    @Column(name = "timestamp")
    @CreatedDate
    private Date Timestamp;

    @Column(name = "value")
    private double Value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idFarm")
    private Farm farm;

    @ManyToOne
    @JoinColumn(name = "idCateg")
    private SensorCategory sensorCategory;


}
