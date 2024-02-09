package org.example.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.example.shoppingmall.domain.review.model.dto.ReviewWithConsumerDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewMapper {

    List<ReviewWithConsumerDto> findByProductId(Long productId);

    int countByProductId(Long productId);
}
