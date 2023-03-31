package com.vuhien.application.service.impl;

import com.vuhien.application.model.dto.ProductCartDTO;
import com.vuhien.application.repository.ProductCartRepository;
import com.vuhien.application.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;
    @Override
    public List<ProductCartDTO> getListProductInCartOfUser(long userId) {
        List<ProductCartDTO> getList = productCartRepository.getListProductInCartOfUser(userId);
        return getList;
    }
}
