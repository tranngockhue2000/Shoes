package com.vuhien.application.service;

import com.vuhien.application.entity.CartProduct;
import com.vuhien.application.model.dto.ProductCartDTO;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    // thêm sản phẩm vào giỏ hàng
    CartProduct addProductToCart(ProductCartDTO productCartDTO);

    //get thông tin giỏ hàng

}
