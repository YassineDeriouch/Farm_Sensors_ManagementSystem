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
@Table(name = "sensorCategory")
public class SensorCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCateg;

    @Column(name = "reference")
    private String Reference;

    @Column(name = "description")
    private String Description;

}
