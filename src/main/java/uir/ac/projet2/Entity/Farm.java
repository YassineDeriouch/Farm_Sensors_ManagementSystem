package uir.ac.projet2.Entity;

import jakarta.persistence.*;
import lombok.Data;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFarm;

    @Column(name = "address")
    private String Address;

    @Column(name = "area")
    private String Area;

    @Column(name = "name")
    private String Name;

    @Column(name = "long")
    private double Long;

    @Column(name = "latitude")
    private double Latitude;

    @Column(name = "description")
    private String Description;

}
