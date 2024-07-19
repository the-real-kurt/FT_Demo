
@Data
@Entity
public class Invoice {

    public List<BillingRecord> billingRecords;
    public Status status;

}