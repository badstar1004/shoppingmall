package org.example.shoppingmall.domain.review.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCountAvgRatingDto {

    private int reviewCount;
    private double avgRating;
}
