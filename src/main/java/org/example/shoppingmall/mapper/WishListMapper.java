package org.example.shoppingmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WishListMapper {
    
    /*
    * 찜목록 저장
    * */
    boolean saveWishList(@Param("consumerId") Long consumerId, @Param("productId") Long productId);
}
