package org.example.shoppingmall.domain.productOption.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOption {

    private Long optionId;
    private Long productId;
    private String optionSize;
    private String optionColor;
    private String rgbValue;
    private int stockQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
