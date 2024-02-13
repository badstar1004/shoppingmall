package org.example.shoppingmall.domain.review.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.example.shoppingmall.domain.product.model.dto.PagingHandle;

@Getter
@Builder
public class ReviewPagingDto {

    private List<ReviewWithConsumerDto> withConsumerDtoList;
    private PagingHandle pagingHandle;
}
