package org.example.shoppingmall.domain.category.controller;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.domain.category.model.CategoryListDto;
import org.example.shoppingmall.domain.category.service.CategoryService;
import org.example.shoppingmall.domain.product.domain.Product;
import org.example.shoppingmall.domain.product.model.dto.PagingHandle;
import org.example.shoppingmall.domain.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    /*
     * 상품 페이지 조회
     * */
    @GetMapping()
    public String getCategory(@RequestParam(name = "main") Long main,
        @RequestParam(name = "sub", required = false) Long sub,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "size", defaultValue = "20") int size,
        Model model) {
        
        // 상위 카테고리에 속한 하위 카테고리 리스트 조회
        CategoryListDto categoryListDto = categoryService.getCategoryList(main);

        // 상위 또는 하위 카테고리에 속한 상품 조회 (페이징)
        List<Product> productList = productService.getProductsByCategory(main, Optional.ofNullable(sub), page, size);

        // 페이징 객체
        PagingHandle pagingHandle = productService.getPagingHandel(main, Optional.ofNullable(sub), page, size);

        model.addAttribute("categoryList", categoryListDto);
        model.addAttribute("productList", productList);
        model.addAttribute("pagingHandle", pagingHandle);

        return "tiles-views/product-list";
    }
}