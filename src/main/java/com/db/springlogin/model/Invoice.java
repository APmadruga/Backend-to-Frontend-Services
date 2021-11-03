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
@Table(indexes = @Index(columnList = "name", unique = true))
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private Long total;
    private String name;

    //invoice has only one User
    @ManyToOne
    private User user;

    //and invoice can have many products
    @ManyToMany(mappedBy = "invoice")
    @Column(nullable=true)
    private List<Product> productList;

}
