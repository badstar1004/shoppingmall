package org.example.shoppingmall.domain.category.domain;

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
