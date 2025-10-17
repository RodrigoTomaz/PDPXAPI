package com.br.pedeplux.models;

import com.br.pedeplux.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "orderId")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_moment")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT"
    )
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "orderItemId.order")
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order(Long orderId, Instant moment, User user, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.moment = moment;
        this.user = user;
        this.orderStatus = orderStatus;
    }
}
