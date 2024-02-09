package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.domain.productImage.domain.ProductImage;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductImageMapper {

    /*
    * 상품 ID 기준 이미지 조회
    * */
    List<ProductImage> findByProductId(Long productId);
}
