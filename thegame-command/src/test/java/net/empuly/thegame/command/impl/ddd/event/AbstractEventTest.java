package net.empuly.thegame.command.impl.ddd.event;

import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersieBuilderForTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.testing.EqualsTester;

public class AbstractEventTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private class SomeEvent extends AbstractEvent {

		SomeEvent(IdMetVersie aggregateRootId) {
			super(aggregateRootId);
		}

	}

	@Test
	public void kanEventNietAanmakenMetIdMeVersieNull() {
		expectedException.expect(NullPointerException.class);
		new SomeEvent(null);
	}

	@Test
	public void equalsAndHashCode() {
		new EqualsTester()
				.addEqualityGroup(
						new SomeEvent(new IdMetVersieBuilderForTests().build()),
						new SomeEvent(new IdMetVersieBuilderForTests().build()))
				.addEqualityGroup(new SomeEvent(new IdMetVersieBuilderForTests().withVersie(5).build()))
				.testEquals();
	}

}
