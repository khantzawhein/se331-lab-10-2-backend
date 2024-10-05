package se331.lab10second.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class BidDto {
    Long id;
    Double amount;
    String datetime;
}
