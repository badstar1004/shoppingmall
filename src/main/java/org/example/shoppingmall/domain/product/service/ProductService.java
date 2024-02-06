package org.example.shoppingmall.domain.product.service;

import java.util.List;
import java.util.Optional;
import org.example.shoppingmall.domain.product.domain.Product;
import org.example.shoppingmall.domain.product.model.dto.PagingHandle;
import org.example.shoppingmall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

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
}
