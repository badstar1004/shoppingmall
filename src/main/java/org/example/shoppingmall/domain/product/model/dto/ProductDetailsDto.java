package org.example.shoppingmall.domain.product.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.shoppingmall.domain.product.domain.Product;
import org.example.shoppingmall.domain.productDescriotion.domain.ProductDescription;
import org.example.shoppingmall.domain.productImage.domain.ProductImage;
import org.example.shoppingmall.domain.productOption.model.ProductOptionColorDto;
import org.example.shoppingmall.domain.productOption.model.ProductOptionSizeDto;

@Getter
@Setter
@Builder
public class ProductDetailsDto {
    private Product product;
    private int reviewCount;
    private List<ProductImage> productImageList;
    private List<ProductOptionSizeDto> optionSizeDtoList;
    private List<ProductOptionColorDto> optionColorDtoList;
    private List<ProductDescription> productDescriptionList;
}
