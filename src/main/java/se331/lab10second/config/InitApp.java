package se331.lab10second.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab10second.entity.AuctionItem;
import se331.lab10second.entity.Bid;
import se331.lab10second.repository.AuctionItemRepository;
import se331.lab10second.repository.BidRepository;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        AuctionItem item1 = AuctionItem.builder().type("Painting").description("A beautiful painting").build();
        AuctionItem item2 = AuctionItem.builder().type("Sculpture").description("A beautiful sculpture").build();
        AuctionItem item3 = AuctionItem.builder().type("Antique").description("A beautiful antique").build();
        AuctionItem item4 = AuctionItem.builder().type("Gold").description("Other beautiful thing").build();
        AuctionItem item5 = AuctionItem.builder().type("Jewellery").description("Other beautiful thing").build();

        Bid successfulBid1 = bidRepository.save(Bid.builder().amount(1000.0).datetime("2024-10-11 00:11:11").auctionItem(item1).build());
        Bid successfulBid2 = bidRepository.save(Bid.builder().amount(1000.0).datetime("2024-10-11 00:21:11").auctionItem(item2).build());
        Bid successfulBid3 = bidRepository.save(Bid.builder().amount(2000.0).datetime("2024-10-11 00:33:11").auctionItem(item3).build());
        // Each item have at least 3 bids, and 3 items have successful bid
        bidRepository.save(Bid.builder().amount(2000.0).datetime("2024-10-11 00:12:11").auctionItem(item1).build());
        bidRepository.save(Bid.builder().amount(3000.0).datetime("2024-10-11 00:13:11").auctionItem(item1).build());
        bidRepository.save(Bid.builder().amount(4000.0).datetime("2024-10-11 00:14:11").auctionItem(item1).build());
        item1.setSuccessfulBid(successfulBid1);

        // Each item have at least 3 bids, and 3 items have successful bid, random amount
        item2.getBidHistory().add(successfulBid2);
        bidRepository.save(Bid.builder().amount(2000.0).datetime("2024-10-11 00:22:11").auctionItem(item2).build());
        bidRepository.save(Bid.builder().amount(3000.0).datetime("2024-10-11 00:23:11").auctionItem(item2).build());
        item2.setSuccessfulBid(successfulBid2);


        // Each item have at least 3 bids, and 3 items have successful bid, random amount
        bidRepository.save(Bid.builder().amount(1000.0).datetime("2024-10-11 00:11:11").auctionItem(item3).build());
        bidRepository.save(Bid.builder().amount(2000.0).datetime("2024-10-11 00:22:11").auctionItem(item3).build());
        bidRepository.save(Bid.builder().amount(3000.0).datetime("2024-10-11 00:33:11").auctionItem(item3).build());
        item3.setSuccessfulBid(successfulBid3);


        // Each item have at least 3 bids, and 3 items have successful bid, random amount
        bidRepository.save(Bid.builder().amount(1000.0).datetime("2024-10-11 00:11:11").auctionItem(item4).build());
        item4.getBidHistory().add(successfulBid3);
        bidRepository.save(Bid.builder().amount(3000.0).datetime("2024-10-11 00:43:11").auctionItem(item4).build());

        // Each item have at least 3 bids, and 3 items have successful bid, random amount
        bidRepository.save(Bid.builder().amount(1000.0).datetime("2024-10-11 00:11:11").auctionItem(item5).build());
        bidRepository.save(Bid.builder().amount(2000.0).datetime("2024-10-11 00:32:11").auctionItem(item5).build());
        bidRepository.save(Bid.builder().amount(3000.0).datetime("2024-10-11 00:43:11").auctionItem(item5).build());

        auctionItemRepository.save(item1);
        auctionItemRepository.save(item2);
        auctionItemRepository.save(item3);
        auctionItemRepository.save(item4);
        auctionItemRepository.save(item5);

    }
}
