package se331.lab10second.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String description, type;
    @OneToMany(mappedBy = "auctionItem")
    @Builder.Default
    List<Bid> bidHistory = new ArrayList<>();
    @OneToOne
    Bid successfulBid;
}
