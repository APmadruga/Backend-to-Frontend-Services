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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long value;
    private String name;
    @ManyToMany
    private List<Invoice> invoice;
}
