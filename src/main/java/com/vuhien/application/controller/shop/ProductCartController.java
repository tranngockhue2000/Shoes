package com.vuhien.application.controller.shop;

import com.vuhien.application.entity.User;
import com.vuhien.application.model.dto.ProductCartDTO;
import com.vuhien.application.repository.ProductCartRepository;
import com.vuhien.application.security.CustomUserDetails;
import com.vuhien.application.service.impl.ProductCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/product-cart")
public class ProductCartController {
    @Autowired
    private ProductCartServiceImpl productCartService;
    @Autowired
    private ProductCartRepository productCartRepository;

    @GetMapping()
    public String getListProductInCartOfUser(Model model){
        User user =((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        List<ProductCartDTO> getListProductInCart = productCartService.getListProductInCartOfUser(user.getId());
        model.addAttribute("listProductInCart", getListProductInCart);
        return "shop/cart";
    }
}
