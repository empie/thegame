package net.empuly.thegame.query.testutils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockitoRule implements TestRule {

	private final Object testWaarinMocksMoetenGeinitialiseerdWorden;

	public MockitoRule(final Object testWaarinMocksMoetenGeinitialiseerdWorden) {
		this.testWaarinMocksMoetenGeinitialiseerdWorden = testWaarinMocksMoetenGeinitialiseerdWorden;

	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				MockitoAnnotations.initMocks(testWaarinMocksMoetenGeinitialiseerdWorden);
				Throwable throwable = null;
				try {
					base.evaluate();
				} catch (final Throwable t) {
					throwable = t;
					throw t;
				} finally {
					try {
						Mockito.validateMockitoUsage();
					} catch (final Throwable t) {
						if (throwable != null) {
							t.printStackTrace();
						} else {
							throw t;
						}
					}
				}
			}
		};
	}
	
}
