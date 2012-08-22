package net.empuly.thegame.web.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import net.empuly.thegame.web.testutil.AbstractThegameSpringMvcTest;

import org.junit.Test;

public class StatischePaginaControllerTest extends AbstractThegameSpringMvcTest {

	@Test
	public void gegeven_EenRequestNaarDeRoot_Dan_redirectNaarLijstVanAlleSpelen() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(model().size(0))
				.andExpect(redirectedUrl(StatischePaginaController.URL_TO_REDIRECT_TO));
	}

}
