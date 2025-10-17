package com.br.pedeplux.models;

import com.br.pedeplux.models.pk.OrderItemPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_orderitem")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "orderItemId")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPk orderItemId;

    @Column(name = "orderitem_quantity")
    private Integer quantity;

    @Column(name = "orderitem_price")
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.orderItemId.setOrder(order);
        this.orderItemId.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return orderItemId.getOrder();
    }

    public void setOrder(Order order){
        orderItemId.setOrder(order);
    }

    public Product getProduct(){
        return orderItemId.getProduct();
    }

    public void setProduct(Product product){
        orderItemId.setProduct(product);
    }
}
