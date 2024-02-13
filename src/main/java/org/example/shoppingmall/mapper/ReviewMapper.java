package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.shoppingmall.domain.review.model.dto.ReviewCountAvgRatingDto;
import org.example.shoppingmall.domain.review.model.dto.ReviewWithConsumerDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewMapper {

    /*
    * 리뷰 count, 평점
    * */
    ReviewCountAvgRatingDto countAndAvgByProductId(Long productId);

    /*
    * 리뷰 페이징
    * */
    List<ReviewWithConsumerDto> findByProductId(@Param("productId") Long productId,
                                                @Param("size") int size,
                                                @Param("offset") int offset);

    int countByProductId(Long productId);
}
