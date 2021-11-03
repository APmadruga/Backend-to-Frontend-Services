package com.db.springlogin.repository;
import com.db.springlogin.model.Invoice;
import com.db.springlogin.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByName(String name);
}
