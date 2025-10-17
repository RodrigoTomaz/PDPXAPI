package com.br.pedeplux.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "productId")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "procuct_name")
    private String name;

    @Column(name = "procuct_description")
    private String description;

    @Column(name = "procuct_price")
    private Double price;

    @Column(name = "procuct_imgUrl")
    private String imgUrl;

    @Transient
    private Set<Category> categories = new HashSet<>();

    private Set<Category> getCategories(){
        return this.categories;
    }

    public Product(Long productId, String name, String description, Double price, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }
}
