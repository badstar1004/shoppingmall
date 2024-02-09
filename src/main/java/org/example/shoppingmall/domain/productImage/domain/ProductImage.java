package org.example.shoppingmall.domain.productImage.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductImage {

    private Long productImageId;
    private Long productId;
    private String imageUrl;
    private char mainImageFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
