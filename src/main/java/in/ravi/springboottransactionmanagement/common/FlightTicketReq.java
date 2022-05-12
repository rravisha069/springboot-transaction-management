package in.ravi.springboottransactionmanagement.common;

import in.ravi.springboottransactionmanagement.entity.PassengerInfo;
import in.ravi.springboottransactionmanagement.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightTicketReq {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
