package test.interview.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import test.interview.demo.domain.Invoice;
import test.interview.demo.service.InvoiceService;

import java.util.List;
import java.util.UUID;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice/{id}")
    public Invoice getInvoice(@PathVariable UUID id ) {
        Invoice invoice = invoiceService.getInvoice(id);
        if( invoice == null ) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "invoice " + id + " not found"
            );
        }
        return invoice;
    }
    @GetMapping("/invoices/{customerNumber}")
    public List<Invoice> getInvoiceByCustomerNumber(@PathVariable int customerNumber ) {
        List<Invoice> invoices = invoiceService.getInvoicesForCustomer(customerNumber);
        if( invoices.isEmpty() ) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No invoices found for customer number " + customerNumber );
        }
        return invoices;
    }
}
