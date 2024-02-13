package org.example.shoppingmall.domain.review.service;

import java.util.List;
import org.example.shoppingmall.domain.product.model.dto.PagingHandle;
import org.example.shoppingmall.domain.review.model.dto.ReviewPagingDto;
import org.example.shoppingmall.domain.review.model.dto.ReviewWithConsumerDto;
import org.example.shoppingmall.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;


    public ReviewPagingDto getReviewList(Long productId, int page, int size) {
        int offset = calculateOffset(page, size);

        List<ReviewWithConsumerDto> withConsumerDtoList = reviewMapper.findByProductId(productId, size, offset);
        PagingHandle pagingHandle = getPagingHandel(productId, page, size);

        return ReviewPagingDto.builder()
            .withConsumerDtoList(withConsumerDtoList)
            .pagingHandle(pagingHandle)
            .build();
    }

    private PagingHandle getPagingHandel(Long productId, int page, int size) {
        int totalReviewCount = reviewMapper.countAndAvgByProductId(productId).getReviewCount();
        return new PagingHandle(totalReviewCount, page, size);
    }

    // offset 계산을 위한 메서드
    private int calculateOffset(int page, int size) {
        return Math.max((page - 1) * size, 0);
    }
}
