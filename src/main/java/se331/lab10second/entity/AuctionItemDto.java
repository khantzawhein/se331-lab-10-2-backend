package se331.lab10second.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class AuctionItemDto {
    Long id;
    String description, type;
    BidDto[] bidHistory ;
    BidDto successfulBid;
}
