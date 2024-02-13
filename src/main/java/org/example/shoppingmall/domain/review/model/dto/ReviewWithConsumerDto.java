package org.example.shoppingmall.domain.review.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewWithConsumerDto {

    private Long reviewId;
    private Long consumerId;
    private Long productId;
    private Double rating;
    private String reviewText;
    private String createdAt;

    private String optionSize;
    private String optionColor;
    private String consumerEmail;
    private String consumerName;
    private String productName;
}
