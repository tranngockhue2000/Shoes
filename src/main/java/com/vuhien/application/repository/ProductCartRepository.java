package com.vuhien.application.repository;

import com.vuhien.application.entity.CartProduct;
import com.vuhien.application.model.dto.ProductCartDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductCartRepository extends JpaRepository<CartProduct, Long> {

    @Query(nativeQuery = true, name= "getListProductInCartOfUser")
    List<ProductCartDTO> getListProductInCartOfUser(long userId);
}
