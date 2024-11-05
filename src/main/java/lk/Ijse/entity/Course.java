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
public class Course {
    @Id
    private String cid;
    private String coursename;
    private String duration;
    private Double fee;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public Course(String cid, String coursename, String duration, Double fee) {
        this.cid = cid;
        this.coursename = coursename;
        this.duration = duration;
        this.fee = fee;
    }
}
