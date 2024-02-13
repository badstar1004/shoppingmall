package org.example.shoppingmall.domain.product.service;

import java.util.List;
import java.util.Optional;
import org.example.shoppingmall.domain.product.domain.Product;
import org.example.shoppingmall.domain.product.model.dto.PagingHandle;
import org.example.shoppingmall.domain.product.model.dto.ProductDetailsDto;
import org.example.shoppingmall.domain.productDescriotion.domain.ProductDescription;
import org.example.shoppingmall.domain.productImage.domain.ProductImage;
import org.example.shoppingmall.domain.productOption.model.ProductOptionColorDto;
import org.example.shoppingmall.domain.productOption.model.ProductOptionSizeDto;
import org.example.shoppingmall.domain.review.model.dto.ReviewCountAvgRatingDto;
import org.example.shoppingmall.mapper.ProductDescriptionMapper;
import org.example.shoppingmall.mapper.ProductImageMapper;
import org.example.shoppingmall.mapper.ProductMapper;
import org.example.shoppingmall.mapper.ProductOptionMapper;
import org.example.shoppingmall.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private ProductDescriptionMapper productDescriptionMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ProductOptionMapper productOptionMapper;


    /*
    * 카테고리의 상품 조회
    * */
    public List<Product> getProductsByCategory(Long mainCategoryId, Optional<Long> subCategoryId, int page, int size) {
        int offset = calculateOffset(page, size);
        return subCategoryId.map(id -> productMapper.findBySubCategoryId(id, size, offset))
            .orElseGet(() -> productMapper.findByMainCategoryId(mainCategoryId, size, offset));
    }

    // offset 계산을 위한 메서드
    private int calculateOffset(int page, int size) {
        return Math.max((page - 1) * size, 0);
    }

    // 페이징 객체 (상위, 하위 카테고리에 따른 상품 count 조회)
    public PagingHandle getPagingHandel(Long mainCategoryId, Optional<Long> subCategoryId, int page, int size) {
        int totalProductCount = subCategoryId.map(id -> productMapper.countBySubCategoryId(id))
            .orElseGet(() -> productMapper.countByMainCategoryId(mainCategoryId));

        return new PagingHandle(totalProductCount, page, size);
    }

    /*
    * 상품 정보 조회
    * */
    public ProductDetailsDto getProductDetails(Long productId) {

        // 상품 정보 조회
        Product product = productMapper.findByProductId(productId);

        // 상품 이미지 조회
        List<ProductImage> productImage = productImageMapper.findByProductId(productId);

        // 사이즈 조회
        List<ProductOptionSizeDto> optionSizeDtoList =
            productOptionMapper.findDistinctSizeByProductId(productId);

        // 색상 조회
        List<ProductOptionColorDto> optionColorDtoList =
            productOptionMapper.findDistinctColorByProductId(productId);

        // 상품 설명 조회
        List<ProductDescription> productDescriptions =
            productDescriptionMapper.findByProductId(productId);

        // 리뷰 총 count
        ReviewCountAvgRatingDto countAvgRatingDto = reviewMapper.countAndAvgByProductId(productId);

        return ProductDetailsDto.builder()
            .product(product)
            .countAvgRatingDto(countAvgRatingDto)
            .productImageList(productImage)
            .optionSizeDtoList(optionSizeDtoList)
            .optionColorDtoList(optionColorDtoList)
            .productDescriptionList(productDescriptions)
            .build();
    }
}
