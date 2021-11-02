package com.db.springlogin.repository;
import com.db.springlogin.model.Invoice;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
