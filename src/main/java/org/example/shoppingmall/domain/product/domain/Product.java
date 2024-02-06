package org.example.shoppingmall.domain.product.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Product {
    private Long productId;
    private Long sellerId;
    private Long categoryId;
    private String productName;
    private int price;
    private char brandFlag;
    private String brandName;
    private String manufacturer;
    private LocalDate saleStartAt;
    private LocalDate saleEndAt;
    private char deliveryFlag;
    private int delivery;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String imageUrl;
}
