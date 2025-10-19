package com.br.pedeplux.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_payment")
@Getter
@Setter
@EqualsAndHashCode(of = "paymentId")
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "payment_moment")
    private Instant moment;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Order order;

    public Payment(){}

    public Payment(Long paymentId, Instant moment, Order order){
        this.paymentId = paymentId;
        this.moment = moment;
        this.order = order;
    }

}
