package org.example.shoppingmall.domain.review.controller;

import org.example.shoppingmall.domain.review.model.dto.ReviewPagingDto;
import org.example.shoppingmall.domain.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    /*
    * 상품 기준 리뷰 조회
    * */
    @GetMapping("{productId}")
    public ResponseEntity<ReviewPagingDto> getProductReviews(@PathVariable Long productId,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "size", defaultValue = "20") int size) {

        // 리뷰 페이징 & 페이징 객체
        ReviewPagingDto reviewPagingDto = reviewService.getReviewList(productId, page, size);

        return new ResponseEntity<>(reviewPagingDto, HttpStatus.OK);
    }
}
