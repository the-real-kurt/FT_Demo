package test.interview.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.interview.demo.domain.Invoice;
import test.interview.demo.repository.InvoiceRepo;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;

    public Invoice getInvoice(UUID id) {
        return invoiceRepo.getById(id);
    }
    public List<Invoice> getInvoicesForCustomer(int customerNumber) {
        return invoiceRepo.getByCustomerNumber(customerNumber);
    }
}
