package com.db.springlogin.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private Long total;

    //invoice has only one User
    @ManyToOne
    private User user;

    //and invoice can have many products
    @OneToMany(mappedBy = "invoice")
    @Column(nullable=true)
    private List<Product> productList;

}
