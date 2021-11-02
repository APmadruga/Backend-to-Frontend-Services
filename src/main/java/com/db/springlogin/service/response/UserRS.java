package com.db.springlogin.service.response;
import com.db.springlogin.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UserRS {
    private Long id;
    private String userName;
    private String password;
    private Long age;
   // private List<Invoice> invoiceList;
}
