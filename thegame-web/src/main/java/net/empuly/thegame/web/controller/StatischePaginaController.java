package net.empuly.thegame.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatischePaginaController {

	public static final String URL_TO_REDIRECT_TO = "/spel/lijst";
	private final static Logger LOGGER = LoggerFactory.getLogger(StatischePaginaController.class);
	
    @RequestMapping("/")
    public String welcomePage() {
    	LOGGER.debug("Request binnen gekregen voor root path. Redirecting to " + URL_TO_REDIRECT_TO);
        return "redirect:" + URL_TO_REDIRECT_TO;
    }
}
