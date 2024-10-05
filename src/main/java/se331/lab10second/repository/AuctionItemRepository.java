package se331.lab10second.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.lab10second.entity.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    @Override
    Page<AuctionItem> findAll(Pageable pageable);

    Page<AuctionItem> findByDescriptionContaining(String description, Pageable pageable);

}
