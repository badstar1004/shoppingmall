package org.example.shoppingmall.mapper;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.domain.category.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CategoryMapper {
    /*
    * 카테고리 조회
    * */
    List<Category> selectCategory();

    /*
    * 카테고리 존재 유무
    * */
    Optional<Category> findByCategoryId(Long categoryId);

    List<Category> findBySubCategoryList(Long categoryId);
}
