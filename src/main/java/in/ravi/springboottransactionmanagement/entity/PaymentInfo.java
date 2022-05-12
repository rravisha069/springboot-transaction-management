package in.ravi.springboottransactionmanagement.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private String accNo;
    private double amount;
    private String cardType;
    // Here we are not using any association mapping because its not needed
    private int passengerId;
}
