package org.example.shoppingmall.domain.wishList.service;

import org.example.shoppingmall.mapper.ConsumerMapper;
import org.example.shoppingmall.mapper.ProductMapper;
import org.example.shoppingmall.mapper.WishListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private WishListMapper wishListMapper;

    /*
    * 찜 목록 저장
    * */
    public boolean addWishList(Long consumerId, Long productId) {
        int consumer = consumerMapper.existsById(consumerId);
        int product = productMapper.existsById(productId);

        if(consumer == 0 || product == 0) {
            return false;
        }
        
        // 저장
        return wishListMapper.saveWishList(consumerId, productId);
    }
}
