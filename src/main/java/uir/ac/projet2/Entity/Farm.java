package uir.ac.projet2.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Youssef on 10/05/2023
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */

@Entity
@Data
@Table(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFarm;

    @Column(name = "address")
    private String Address;

    @Column(name = "area")
    private String Area;

    @Column(name = "name")
    private String Name;

    @Column(name = "longitude")
    private double Longitude;

    @Column(name = "latitude")
    private double Latitude;

    @Column(name = "description")
    private String Description;

    @OneToMany
    @JoinColumn(name = "idSensor")
    private List<Sensor> SensorList;

    @OneToMany(mappedBy = "farm")
    private List<User_Farm_Link> userFarms;

}
