package in.ravi.springboottransactionmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PASSENGER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassengerInfo {
    @Id
    @GeneratedValue
    private int passengerId;
    private String passengerName;
    private String source;
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date travelDate;
    private String pickUpTime;
    private String dropTime;
    private double fare;
}
