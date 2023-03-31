package com.vuhien.application.service;

import com.vuhien.application.model.dto.ProductCartDTO;

import java.util.List;

public interface ProductCartService {
    List<ProductCartDTO> getListProductInCartOfUser(long userId);
}
