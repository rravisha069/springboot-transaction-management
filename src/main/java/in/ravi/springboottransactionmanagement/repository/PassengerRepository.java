package in.ravi.springboottransactionmanagement.repository;

import in.ravi.springboottransactionmanagement.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerInfo, Integer> {
}
