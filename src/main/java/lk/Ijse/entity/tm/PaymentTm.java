package lk.Ijse.entity.tm;
import lombok.*;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PaymentTm {
    private String id;
    private String eid;
    private Double amount;
    private LocalDate date;

}
