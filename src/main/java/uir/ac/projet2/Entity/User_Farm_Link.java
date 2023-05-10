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
@Table(name = "user_farm_link")
public class User_Farm_Link {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "farm_id")
        private Farm farm;

        private String profile;
    }

