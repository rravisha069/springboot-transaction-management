package in.ravi.springboottransactionmanagement.controller;

import in.ravi.springboottransactionmanagement.common.FlightBookingAcknowledgement;
import in.ravi.springboottransactionmanagement.common.FlightTicketReq;
import in.ravi.springboottransactionmanagement.exception.InsufficientBalanceInAccount;
import in.ravi.springboottransactionmanagement.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightTicketController {

    @Autowired
    private FlightTicketService service;

    @PostMapping("/bookTicket")
    public FlightBookingAcknowledgement bookTicket(@RequestBody FlightTicketReq req) throws InsufficientBalanceInAccount {
        return service.bookTicket(req);
    }
}
