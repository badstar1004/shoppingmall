package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.domain.productDescriotion.domain.ProductDescription;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductDescriptionMapper {

    /*
    * 상품 ID 기준 상품 상세 조회
    * */
    List<ProductDescription> findByProductId(Long productId);
}
