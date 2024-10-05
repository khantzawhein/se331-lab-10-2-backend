package se331.lab10second.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.lab10second.dao.AuctionItemDao;
import se331.lab10second.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class AuctionItemController {
    final AuctionItemDao auctionItemDao;

    @GetMapping("/auctionItems")
    ResponseEntity<?> getAuctionItems(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "_limit", required = false) Integer pageSize) {

        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 3 : pageSize;
        if (keyword == null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItem(auctionItemDao.getAuctionItems(pageSize, page).getContent()));
        }
        return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItem(auctionItemDao.getAuctionItemsByDescription(keyword, pageSize, page).getContent()));
    }
}
