package lk.Ijse.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class User {
    @Id
    private String userid;
    private String username;
    private String password;
    private String email;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Student> studentList = new ArrayList<>();

    public User(String userid, String username, String password, String email, String role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
