package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.domain.productOption.model.ProductOptionColorDto;
import org.example.shoppingmall.domain.productOption.model.ProductOptionSizeDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductOptionMapper {

    /*
    * 사이즈 조회 (중복제거)
    * */
    List<ProductOptionSizeDto> findDistinctSizeByProductId(Long productId);

    /*
    * 색상 조회 (중복제거)
    * */
    List<ProductOptionColorDto> findDistinctColorByProductId(Long productId);
}
