package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "user")
public class User {

    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "roles", nullable = false)
    private List<UserRole> userRoles;

    public  User(String email, String password, List<UserRole> list) {
        this.email=email;
        this.password=password;
        userRoles= list;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}