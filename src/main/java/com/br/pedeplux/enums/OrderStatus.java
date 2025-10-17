package com.br.pedeplux.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    OrderStatus(int code){
        this.code = code;
    }

    private final int code;

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        };
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
