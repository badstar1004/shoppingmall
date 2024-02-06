package org.example.shoppingmall.domain.category.service;

import static org.example.shoppingmall.grobal.exception.business.ErrorCode.NOT_FOUND_CATEGORY;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.domain.category.model.CategoryListDto;
import org.example.shoppingmall.grobal.exception.business.BusinessException;
import org.example.shoppingmall.mapper.CategoryMapper;
import org.example.shoppingmall.domain.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> selectCategory() {
        log.info("selectCategory start");
        return categoryMapper.selectCategory();
    }

    /*
    * 상위 카테고리와 하위 카테고리 조회
    * */
    public CategoryListDto getCategoryList(Long main) {
        try {
            Category category = categoryMapper.findByCategoryId(main)
                .orElseThrow(() -> new BusinessException(NOT_FOUND_CATEGORY));

            List<Category> subCategoryList =
                categoryMapper.findBySubCategoryList(category.getCategoryId());

            return CategoryListDto.builder()
                .mainCategory(category)
                .subCategriesList(subCategoryList)
                .build();

        } catch (BusinessException ex) {
            throw ex;
        }
    }
}
