package org.example.shoppingmall.domain.review.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {

    private Long reviewId;
    private Long consumerId;
    private Long productId;
    private double rating;
    private String reviewText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
