package lk.Ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid; // Change to Long for auto-incrementing

    @ManyToOne
    @JoinColumn(name = "sid")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Course course;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<Payment> paymentList = new ArrayList<>();

    private LocalDate date;
    private Double upfrontpayment;
    private Double remainingfee;
    private String comment;
}
