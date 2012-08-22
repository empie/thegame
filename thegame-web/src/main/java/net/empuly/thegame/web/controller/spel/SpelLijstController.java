package net.empuly.thegame.web.controller.spel;

import java.util.List;

import javax.inject.Inject;

import net.empuly.thegame.query.api.domain.spel.SpelSnapshot;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spel")
public class SpelLijstController {

	public static final String NAAM_OP_MODEL_SPELEN = "spelen";

	public static final String VIEW_NAME_TILE_DEFINITION = "/spel/spelLijstTileDefinition";

	private final static Logger LOGGER = LoggerFactory.getLogger(SpelLijstController.class);

	@Inject
	private SpelSnapshotRepository spelSnapshotRepository;

	@RequestMapping(value = "/lijst", method = RequestMethod.GET)
	public String spelLijst(final Model model) {
		final List<SpelSnapshot> spelen = spelSnapshotRepository.alleSpelen();
		LOGGER.debug("Aantal opgehaalde spelen op model gezet: " + spelen.size());
		model.addAttribute(NAAM_OP_MODEL_SPELEN, spelen);
		LOGGER.debug("View name om te renderen: " + VIEW_NAME_TILE_DEFINITION);
		return VIEW_NAME_TILE_DEFINITION;
	}

}
