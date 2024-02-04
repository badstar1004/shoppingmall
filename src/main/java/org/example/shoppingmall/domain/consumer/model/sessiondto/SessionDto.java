package org.example.shoppingmall.domain.consumer.model.sessiondto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SessionDto {

    private Long consumerId;
    private String consumerName;
    private int wishCount;
    private int basketCount;
}
