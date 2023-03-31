package com.vuhien.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartDTO {
    private String productId;

    private long cartId;

    private int productPrice;

    private int quantityProduct;

    private int statusProduct;

    private String productName;

    private int sizeProduct;

    private String productImg;

}
