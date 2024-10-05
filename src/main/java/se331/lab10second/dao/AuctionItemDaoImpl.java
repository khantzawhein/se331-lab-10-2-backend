package se331.lab10second.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab10second.entity.AuctionItem;
import se331.lab10second.repository.AuctionItemRepository;

@Repository
@RequiredArgsConstructor
public class AuctionItemDaoImpl implements AuctionItemDao{
    final AuctionItemRepository auctionItemRepository;

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<AuctionItem> getAuctionItemsByDescription(String description, Integer pageSize, Integer page) {
        return auctionItemRepository.findByDescriptionContaining(description, PageRequest.of(page - 1, pageSize));
    }
}
