package net.empuly.thegame.query.testutils;

import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class FixedDateTimeRule extends TestWatcher {
	
	public final static FixedDateTimeRule create() {
		return new FixedDateTimeRule();
	}

	@Override
	public void finished(Description description) {
		reset();
	}

	public void setFixed(int year, int month, int day) {
		setFixed(new LocalDate(year, month, day));
	}

	public void setFixed(LocalDate localDate) {
		DateTimeUtils.setCurrentMillisFixed(localDate.toDateMidnight().getMillis());
	}

	public void setFixed(LocalDateTime localDateTime) {
		DateTimeUtils.setCurrentMillisFixed(localDateTime.toDateTime().getMillis());
	}

	public void setFixedNow() {
		setFixed(new LocalDate(System.currentTimeMillis()));
	}

	public void setFixedTomorrow() {
		setFixed(new LocalDate().plusDays(1));
	}

	public void setFixedYesterday() {
		setFixed(new LocalDate().minusDays(1));
	}

	public void reset() {
		DateTimeUtils.setCurrentMillisSystem();
	}
}
