package org.example.shoppingmall.domain.category.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.shoppingmall.domain.category.domain.Category;

@Getter
@Setter
@Builder
public class CategoryListDto {

    private Category mainCategory;
    private List<Category> subCategriesList;
}
