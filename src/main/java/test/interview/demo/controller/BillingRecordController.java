package test.interview.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import test.interview.demo.domain.BillingRecord;
import test.interview.demo.service.BillingRecordService;

import java.util.List;

@RestController
public class BillingRecordController {

    private final BillingRecordService billingRecordService;

    @Autowired
    public BillingRecordController(BillingRecordService billingRecordService) {
        this.billingRecordService = billingRecordService;
    }

    @GetMapping("/billingRecords/{customerNumber}")
    public List<BillingRecord> getInvoicesForCustomer(@PathVariable int customerNumber) {
        List<BillingRecord> billingRecords = billingRecordService.getByCustomerNumber(customerNumber); // <1
        if( billingRecords.isEmpty() ) {// <2
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No billing records found for customer number " + customerNumber);
        }
        return billingRecordService.getByCustomerNumber(customerNumber);
    }
}
