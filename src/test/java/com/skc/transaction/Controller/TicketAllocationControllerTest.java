package com.skc.transaction.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.skc.transaction.controller.TicketAllocationController;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketAllocationController.class)
public class TicketAllocationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getTicketTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v/ticket"))				
				.andExpect(status().isOk());
	}

}
