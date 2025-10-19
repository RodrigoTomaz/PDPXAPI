package com.br.pedeplux.models;

import com.br.pedeplux.models.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_orderitem")
@NoArgsConstructor
@EqualsAndHashCode(of = "orderItemId")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPk orderItemId = new OrderItemPk();

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

    @JsonIgnore
    public Order getOrder(){
        return orderItemId.getOrder();
    }

    public void setOrder(Order order){
        orderItemId.setOrder(order);
    }
    @JsonIgnore
    public Product getProduct(){
        return orderItemId.getProduct();
    }

    public void setProduct(Product product){
        orderItemId.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
