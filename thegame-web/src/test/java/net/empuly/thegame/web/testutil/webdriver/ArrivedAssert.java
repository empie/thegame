package net.empuly.thegame.web.testutil.webdriver;

import static com.google.common.base.Preconditions.checkNotNull;

import org.fest.assertions.Assertions;

public class ArrivedAssert {

	public static <T extends Pagina<?>> ArrivedAssert assertThat(final T pagina) {
		return new ArrivedAssert(pagina);
	}

	private final Pagina<?> pagina;

	public ArrivedAssert(final Pagina<?> pagina) {
		checkNotNull(pagina);
		this.pagina = pagina;
	}

	public void arrivedAt() {
		Assertions.assertThat(pagina.arrivedAt()).isTrue();
	}

}
