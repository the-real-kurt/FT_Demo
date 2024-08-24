package test.interview.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.interview.demo.domain.BillingRecord;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingRecordRepo {

    public List<BillingRecord> getAllBillingRecords() {
        return FakeDB.allBillingRecords;
    }
    public List<BillingRecord> getAllByCustomerNumber(int customerNumber) {
        return FakeDB.allBillingRecords
                .stream()
                .filter(br -> br.getUser().getCustomerNumber() == customerNumber)
                .toList();
    }

}