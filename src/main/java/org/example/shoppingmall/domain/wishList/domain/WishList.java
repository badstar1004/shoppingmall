package org.example.shoppingmall.domain.wishList.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishList {
    private Long wishListId;
    private Long consumerId;
    private Long productId;
}
