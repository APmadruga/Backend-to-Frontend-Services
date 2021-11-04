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
    @ManyToOne
    private User user;
    @ManyToMany(mappedBy = "invoice")
    @Column(nullable=true)
    private List<Product> productList;
}
