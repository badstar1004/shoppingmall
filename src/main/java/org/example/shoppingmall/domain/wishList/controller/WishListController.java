package org.example.shoppingmall.domain.wishList.controller;

import org.example.shoppingmall.domain.wishList.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wish-list")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("{consumerId}/{productId}")
    public ResponseEntity<Void> addWishList(@PathVariable Long consumerId, @PathVariable Long productId) {
        return wishListService.addWishList(consumerId, productId) ?
            new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
