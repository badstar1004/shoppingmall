package org.example.shoppingmall.domain.category.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Category {

    private Long categoryId;
    private Long parentCategoryId;
    private String categoryName;
    private String categoryEnName;
}
