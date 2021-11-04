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
public class User {
    @Id
    private Long id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
    private Long age;
    @OneToMany(mappedBy = "user")
    @Column(nullable=true)
    private List<Invoice> invoiceList;
}
