    package uir.ac.projet2.Entity;

    import jakarta.persistence.*;
    import lombok.Data;

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
    @Table(name = "user")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idUser;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String Email;

        @Column(name = "phone")
        private String Phone;

        @Column(name = "login")
        private String Login;

        @Column(name = "password")
        private String Password;

        @OneToMany(mappedBy = "user")
        private List<User_Farm_Link> userFarms;

    }
