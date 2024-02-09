package org.example.shoppingmall.domain.product.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private Long productId;
    private Long sellerId;
    private Long categoryId;
    private String productName;
    private int price;
    private LocalDate saleStartAt;
    private LocalDate saleEndAt;
    private char deliveryFlag;
    private int delivery;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
