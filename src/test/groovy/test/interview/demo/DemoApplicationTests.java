package test.interview.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private static final String ID2="11111111-1111-1111-1111-111111111112";


	@Test
	void contextLoads() {
	}

	@Test
	void testGetInvoice() throws Exception {
		mockMvc.perform(get("/invoice/11111111-1111-1111-1111-111111111111")).andExpect(status().isOk());
	}

	@Test
	void getNonExistentInvoice() throws Exception {
		mockMvc.perform(get("/invoice/11111111-4321-1111-1111-111111111112")).andExpect(status().isNotFound());
	}

	@Test
	void testGetInvoiceWithBillingRecords() throws Exception {
		mockMvc.perform(get("/invoice/"+ID2)).andExpect(status().isOk()).andExpect( jsonPath("$.id").value(ID2) );
	}

	@Test
	void getAllInvoicesForUser() throws Exception {
		mockMvc.perform(get("/invoices/1")).andExpect(status().isOk());
	}

	@Test
	void getAllBillingRecordsForUser() throws Exception {
		mockMvc.perform(get("/billingRecords/1")).andExpect(status().isOk());
	}

	@Test
	void getInvoicesForNonExistentUser() throws Exception {
		mockMvc.perform(get("/invoices/-1")).andExpect(status().isNotFound());
	}
	@Test
	void getBillingRecordsForNonExistentUser() throws Exception {
		mockMvc.perform(get("/billingRecords/-1")).andExpect(status().isNotFound());
	}
}
