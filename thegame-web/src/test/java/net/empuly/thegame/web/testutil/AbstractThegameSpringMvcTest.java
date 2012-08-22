package net.empuly.thegame.web.testutil;

import net.empuly.thegame.query.testutils.MockitoRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * Meer info over gebruik van spring test mvc:
 * http://rstoyanchev.github.com/spring-31-and-mvc-test/#99
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		loader = WebContextLoader.class,
		locations = { "classpath:context-thegame-app.xml", "file:src/main/webapp/WEB-INF/context-thegame-servlet.xml" })
public abstract class AbstractThegameSpringMvcTest {
	
	@Rule
	public MockitoRule mockitoRule = new MockitoRule(this);
	
	@Autowired
	private WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void initialiseerMockMvc() {
		this.mockMvc = MockMvcBuilders.webApplicationContextSetup(this.wac).build();
	}

}
