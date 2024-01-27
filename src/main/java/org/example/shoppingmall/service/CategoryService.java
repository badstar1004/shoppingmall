package org.example.shoppingmall.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.mapper.CategoryMapper;
import org.example.shoppingmall.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> selectCategory() {
        log.info("selectCategory start");
        return categoryMapper.selectCategory();
    }
}
