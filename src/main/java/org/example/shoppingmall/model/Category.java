package org.example.shoppingmall.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {

    private Long categoryId;
    private Long parentCategoryId;
    private String categoryName;
    private String categoryEnName;
}
