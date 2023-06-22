package com.saama;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.saama.api.controller.AuthApiController;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Import(AuthApiController.class)
public class AuthModuleApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetUserRole() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/user/{id}/roles", 3001L).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

	}
	

}
