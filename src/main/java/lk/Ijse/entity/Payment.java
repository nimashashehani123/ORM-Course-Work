package lk.Ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Change to Long for auto-incrementing

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment; // Many-to-One relationship to Enrollment

    private LocalDate date;
}
