package se331.lab10second.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab10second.entity.AuctionItem;
import se331.lab10second.entity.AuctionItemDto;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    AuctionItemDto getAuctionItem(AuctionItem auctionItem);
    List<AuctionItemDto> getAuctionItem(List<AuctionItem> auctionItems);
}
