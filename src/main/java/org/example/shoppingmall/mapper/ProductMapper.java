package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.shoppingmall.domain.product.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper {

    /*
    * 상위 카테고리 기준 상품 조회
    * */
    List<Product> findByMainCategoryId(@Param("mainCategoryId") Long mainCategoryId,
                                       @Param("size") int size,
                                       @Param("offset") int offset);

    /*
    * 하위 카테고리 기준 상품 조회
    * */
    List<Product> findBySubCategoryId(@Param("subCategoryId") Long subCategoryId,
                                      @Param("size") int size,
                                      @Param("offset") int offset);

    /*
    * 상위 카테고리 기준 상품 count
    * */
    int countByMainCategoryId(Long mainCategoryId);

    /*
    * 하위 카테고리 기준 상품 count
    * */
    int countBySubCategoryId(Long subCategoryId);
}
