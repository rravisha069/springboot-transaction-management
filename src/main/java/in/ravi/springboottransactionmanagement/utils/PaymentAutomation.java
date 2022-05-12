package in.ravi.springboottransactionmanagement.utils;

import in.ravi.springboottransactionmanagement.exception.InsufficientBalanceInAccount;

import java.util.HashMap;
import java.util.Map;

public class PaymentAutomation {

    private static Map<String, Double> accMap = new HashMap<>();

    static {
        accMap.put("acc1", 12000.0);
        accMap.put("acc2", 10000.0);
        accMap.put("acc3", 5000.0);
        accMap.put("acc4", 8000.0);
    }

    public static boolean customizedPaymentMethod(String accName, double amount) throws InsufficientBalanceInAccount {
        if(amount > accMap.get(accName)) {
            throw new InsufficientBalanceInAccount("Insufficient account balance");
        } else {
            return true;
        }
    }
}
