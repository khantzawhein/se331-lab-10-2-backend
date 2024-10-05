package se331.lab10second.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab10second.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
    
}
