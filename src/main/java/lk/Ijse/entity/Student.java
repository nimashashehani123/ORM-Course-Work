package lk.Ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Student {
    @Id
    private String sid;
    private String name;
    private String address;
    private String tel;
    private String email;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public Student(String sid, String name, String address, String tel, String email, User user) {
        this.sid = sid;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.user = user;
    }
}
