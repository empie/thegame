package net.empuly.thegame.web.controller.spel;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import net.empuly.thegame.query.api.domain.spel.SpelSnapshot;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotRepository;
import net.empuly.thegame.web.testutil.AbstractThegameSpringMvcTest;

import org.hamcrest.core.IsSame;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class SpelLijstControllerTest extends AbstractThegameSpringMvcTest {

	@Mock
	private SpelSnapshotRepository spelSnapshotRepositoryMock;
	
	@Autowired
	@InjectMocks
	private SpelLijstController spelLijstController;
	
	@Test
	public void gegeven_eenRequestNaarDeSpelLijst_dan_alleSpelenOpModelGezetEnNaarJuisteViewStuurd() throws Exception {
		final List<SpelSnapshot> alleSpelen = new ArrayList<SpelSnapshot>();
		
		when(spelSnapshotRepositoryMock.alleSpelen()).thenReturn(alleSpelen);
		
		mockMvc.perform(get("/spel/lijst"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(model().hasNoErrors())
				.andExpect(model().attribute(SpelLijstController.NAAM_OP_MODEL_SPELEN, new IsSame<List<SpelSnapshot>>(alleSpelen)))
				.andExpect(view().name(SpelLijstController.VIEW_NAME_TILE_DEFINITION));
	}
}
