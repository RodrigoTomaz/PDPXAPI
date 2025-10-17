package com.br.pedeplux.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "userId")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_cellfone")
    private String cellfone;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public User(String name, String username, String password, String cellfone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.cellfone = cellfone;
    }
}
