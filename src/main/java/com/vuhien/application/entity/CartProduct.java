package com.vuhien.application.entity;

import com.vuhien.application.model.dto.ProductCartDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@SqlResultSetMappings(
        value = {
                @SqlResultSetMapping(
                        name = "productCartDTO",
                        classes = @ConstructorResult(
                                targetClass = ProductCartDTO.class,
                                columns = {
                                        @ColumnResult(name = "productId", type = String.class),
                                        @ColumnResult(name = "cartId", type = Long.class),
                                        @ColumnResult(name = "productPrice", type = Integer.class),
                                        @ColumnResult(name = "quantityProduct", type = Integer.class),
                                        @ColumnResult(name = "statusProduct", type = Integer.class),
                                        @ColumnResult(name = "productName", type = String.class),
                                        @ColumnResult(name = "sizeProduct", type = Integer.class),
                                        @ColumnResult(name = "productImg", type = String.class),
                                }
                        )
                )
        }
)
@NamedNativeQuery(
        name = "getListProductInCartOfUser",
        resultSetMapping = "productCartDTO",
        query = "SELECT pc.product_id AS productId, pc.cart_id as cartId, p.price AS productPrice, pc.quantity AS quantityProduct, p.`status` AS statusProduct, p.name AS productName, pc.size AS sizeProduct, replace(JSON_EXTRACT(p.images, '$[0]'), '\"', '') AS productImg \n" +
                "FROM product_cart pc \n" +
                "INNER JOIN product p ON p.id = pc.product_id \n" +
                "INNER JOIN cart c ON c.id = pc.cart_id\n" +
                "WHERE c.user_id = 1"
)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_cart")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "size")
    private Integer size;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
