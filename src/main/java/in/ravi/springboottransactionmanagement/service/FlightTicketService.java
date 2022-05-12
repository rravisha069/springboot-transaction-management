package in.ravi.springboottransactionmanagement.service;

import in.ravi.springboottransactionmanagement.common.FlightBookingAcknowledgement;
import in.ravi.springboottransactionmanagement.common.FlightTicketReq;
import in.ravi.springboottransactionmanagement.entity.PassengerInfo;
import in.ravi.springboottransactionmanagement.entity.PaymentInfo;
import in.ravi.springboottransactionmanagement.exception.InsufficientBalanceInAccount;
import in.ravi.springboottransactionmanagement.repository.PassengerRepository;
import in.ravi.springboottransactionmanagement.repository.PaymentRepository;
import in.ravi.springboottransactionmanagement.utils.PaymentAutomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@org.springframework.stereotype.Service
public class FlightTicketService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

//    FlightTicketReq
//    {
//        "passengerInfo": {
//        "passengerName": "Shankar",
//                "source": "Madurai",
//                "destination": "Chennai",
//                "travelDate": "23-05-2022",
//                "pickUpTime": "9.00 PM",
//                "dropTime": "5.00 AM",
//                "fare": 11000.0
//    },
//        "paymentInfo" : {
//        "accNo": "acc2",
//                "cardType": "debit"
//    }
//    }
    @Transactional(readOnly = false , rollbackFor = Exception.class)
    public FlightBookingAcknowledgement bookTicket(FlightTicketReq request) throws InsufficientBalanceInAccount {
        PassengerInfo passengerInfo = request.getPassengerInfo();
        PaymentInfo paymentInfo = request.getPaymentInfo();

        passengerRepository.save(passengerInfo);
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPassengerId());

        PaymentAutomation.customizedPaymentMethod(paymentInfo.getAccNo(), paymentInfo.getAmount());

        paymentRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("Success", paymentInfo.getAmount(), UUID.randomUUID().toString(), passengerInfo);
    }
}
