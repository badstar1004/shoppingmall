package org.example.shoppingmall.domain.productDescriotion.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDescription {
    private Long productDescriptionId;
    private Long productId;
    private String contentsType;
    private String contentsValue;
    private int sequence;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
