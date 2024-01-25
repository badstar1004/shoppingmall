package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.model.Category;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CategoryMapper {

    List<Category> selectCategory();
}
