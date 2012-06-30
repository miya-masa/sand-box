package time.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;

import time.calculate.TimeCalculator;
import time.structure.TimeStructure;

public class TimeCaluculatorTest {

	@Test
	public void testYear() {
		TimeCalculator caluculator = new TimeCalculator();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(0);
		calendar.add(Calendar.YEAR, 1);
		compare(calendar,
				caluculator.calculateTime(TimeCalculator.SECOND_PER_YEAH));
		calendar.add(Calendar.YEAR, 3);
		compare(calendar,
				caluculator.calculateTime(TimeCalculator.SECOND_PER_YEAH * 3
						+ TimeCalculator.SECOND_PER_YEAH_LEEP));
	}

	@Test
	public void testCaluculateTime() {
		TimeCalculator caluculator = new TimeCalculator();
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		long now = System.currentTimeMillis();
		calendar.setTimeInMillis(now);
		compare(calendar, caluculator.calculateTime(now / 1000));
		long toolongTime = 1000000000000000000l;
		calendar.setTimeInMillis(toolongTime);
		compare(calendar, caluculator.calculateTime(toolongTime / 1000));

	}

	private void compare(Calendar calendar, TimeStructure structure) {
		System.out.println(structure.toString());
		assertThat(structure.getYear(), is(calendar.get(Calendar.YEAR)));
		assertThat(structure.getMonth(), is(calendar.get(Calendar.MONTH)));
		assertThat(structure.getDay(), is(calendar.get(Calendar.DAY_OF_MONTH)));
		assertThat(structure.getHour() + 9,
				is(calendar.get(Calendar.HOUR_OF_DAY)));
		assertThat(structure.getMinute(), is(calendar.get(Calendar.MINUTE)));
		assertThat(structure.getSecond(), is(calendar.get(Calendar.SECOND)));

	}

}
