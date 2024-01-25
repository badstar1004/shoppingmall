package org.example.shoppingmall.service;

import java.util.List;
import org.example.shoppingmall.mapper.CategoryMapper;
import org.example.shoppingmall.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> selectCategory() {
      return categoryMapper.selectCategory();
    }
}
