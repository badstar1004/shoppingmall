package org.example.shoppingmall.domain.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.domain.product.model.dto.ProductDetailsDto;
import org.example.shoppingmall.domain.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/details/{productId}")
    public String getProductDetails(@PathVariable Long productId, Model model) {

        ProductDetailsDto detailsDto = productService.getProductDetails(productId);

        model.addAttribute("productDetails", detailsDto);

        return "tiles-views/product-details";
    }
}
