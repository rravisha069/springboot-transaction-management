package in.ravi.springboottransactionmanagement.repository;

import in.ravi.springboottransactionmanagement.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentInfo, Integer> {
}
