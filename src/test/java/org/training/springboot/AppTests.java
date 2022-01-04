package org.training.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nous.app.NuiCalApp;

/**
 * Unit test for NuiCalApp.
 */
@SpringBootTest(classes = NuiCalApp.class)
@AutoConfigureMockMvc
public class AppTests {
    
	@Autowired
    MockMvc mockMvc;
	
	@Test
	@WithMockUser(username = "user", password = "user1234")
	public void testWish() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/wish/hello"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username = "user", password = "user1234")
	public void testAdmin() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/api/allHolidays"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
