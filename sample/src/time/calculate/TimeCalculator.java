package time.calculate;

import time.structure.TimeStructure;

public class TimeCalculator {

	private enum Month {
		JANUARY(1, SECOND_PER_MONTH_THRTY_ONE), FEBURUARY(2,
				SECOND_PER_MONTH_TWENTY_EIGHT), FEBURUARY_LEEP(2,
				SECOND_PER_MONTH_TWENTY_NINE), MARCH(3,
				SECOND_PER_MONTH_THRTY_ONE), APRIL(4, SECOND_PER_MONTH_THRTY), MAY(
				5, SECOND_PER_MONTH_THRTY_ONE), JUNE(6, SECOND_PER_MONTH_THRTY), JULY(
				7, SECOND_PER_MONTH_THRTY_ONE), AUGUST(8,
				SECOND_PER_MONTH_THRTY_ONE), SEPTEMBER(9,
				SECOND_PER_MONTH_THRTY), OCTOBER(10, SECOND_PER_MONTH_THRTY_ONE), NOVEMBER(
				11, SECOND_PER_MONTH_THRTY), DECEMBER(12,
				SECOND_PER_MONTH_THRTY_ONE);

		private int num;
		private long second;

		private Month(int num, long second) {
			this.num = num;
			this.second = second;
		}

		public int getNum() {
			return num;
		}

		public long getSecond() {
			return second;
		}
	};

	public static final long SECOND_PER_MINUTE = 60;
	public static final long SECOND_PER_HOUR = SECOND_PER_MINUTE * 60;
	public static final long SECOND_PER_DAY = SECOND_PER_HOUR * 24;
	public static final long SECOND_PER_MONTH_THRTY = SECOND_PER_DAY * 30;
	public static final long SECOND_PER_MONTH_THRTY_ONE = SECOND_PER_DAY * 31;
	public static final long SECOND_PER_MONTH_TWENTY_EIGHT = SECOND_PER_DAY * 28;
	public static final long SECOND_PER_MONTH_TWENTY_NINE = SECOND_PER_DAY * 29;
	public static final long SECOND_PER_YEAH = SECOND_PER_DAY * 365;
	public static final long SECOND_PER_YEAH_LEEP = SECOND_PER_DAY * 366;
	public static final long SECOND_PER_CYCLE = (SECOND_PER_YEAH * 303)
			+ (SECOND_PER_YEAH_LEEP * 97);
	public static final int BASE_YEAR = 1970;
	public static final Month[] YEAR_MONTH_LIST = { Month.JANUARY,
			Month.FEBURUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE,
			Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER,
			Month.NOVEMBER, Month.DECEMBER };
	public static final Month[] LEEP_YEAR_MONTH_LIST = { Month.JANUARY,
			Month.FEBURUARY_LEEP, Month.MARCH, Month.APRIL, Month.MAY,
			Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER,
			Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER };

	public TimeStructure calculateTime(long time) {
		TimeStructure structure = new TimeStructure();
		long diff = caluclateYear(structure, time);
		diff = calclateMonth(structure, diff, structure.getYear());
		diff = calclateDay(structure, diff, structure.getMonth(),
				structure.getYear());
		diff = calclateHour(structure, diff);
		diff = caluclateMinute(structure, diff);
		structure.setSecond(Long.valueOf(diff).intValue());
		return structure;
	}

	private long caluclateMinute(TimeStructure structure, long time) {
		int minute = 0;
		long diff = time;
		while (diff >= SECOND_PER_MINUTE) {
			diff = diff - SECOND_PER_MINUTE;
			minute++;
		}
		structure.setMinute(minute);
		return diff;
	}

	private long calclateHour(TimeStructure structure, long time) {
		int hour = 0;
		long diff = time;
		while (diff >= SECOND_PER_HOUR) {
			diff = diff - SECOND_PER_HOUR;
			hour++;
		}
		structure.setHour(hour);
		return diff;
	}

	private long calclateDay(TimeStructure structure, long time, int month,
			int year) {
		long diff = time;
		int day = 1;

		while (diff >= SECOND_PER_DAY) {
			diff = diff - SECOND_PER_DAY;
			day++;
		}
		structure.setDay(day);
		return diff;
	}

	private long calclateMonth(TimeStructure structure, long time, int year) {
		long diff = time;
		long secondThisMonth = 0;
		Month[] monthlist = null;
		if (isLeepyear(year)) {
			monthlist = LEEP_YEAR_MONTH_LIST;
		} else {
			monthlist = YEAR_MONTH_LIST;
		}
		Month thisMonth = null;
		for (Month month : monthlist) {
			secondThisMonth = month.getSecond();
			if (diff >= secondThisMonth) {
				// ·‚ª‚»‚ÌŒŽ‚æ‚è‘å‚«‚¢ê‡
				diff = diff - secondThisMonth;
			} else {
				thisMonth = month;
				break;
			}
		}
		if (thisMonth == null) {
			throw new IllegalArgumentException("ŒŽŒvŽZŽ¸”sBˆø”‚ÌŽžŠÔ‚ªˆê”N‚æ‚è’·‚¢B");
		}
		structure.setMonth(thisMonth.getNum() - 1);
		return diff;
	}

	private long caluclateYear(TimeStructure structure, long time) {
		long yearCount = BASE_YEAR;
		long diff = time;
		while (diff >= SECOND_PER_CYCLE) {
			diff = diff - SECOND_PER_CYCLE;
			yearCount = yearCount + 400;
		}
		long secondThisYear = 0;
		if (isLeepyear(yearCount)) {
			secondThisYear = SECOND_PER_YEAH_LEEP;
		} else {
			secondThisYear = SECOND_PER_YEAH;
		}
		while (diff >= secondThisYear) {
			diff = diff - secondThisYear;
			yearCount++;
			if (isLeepyear(yearCount)) {
				secondThisYear = SECOND_PER_YEAH_LEEP;
			} else {
				secondThisYear = SECOND_PER_YEAH;
			}

		}
		structure.setYear(Long.valueOf(yearCount).intValue());
		return diff;
	}

	private boolean isLeepyear(long baseYear) {
		if (baseYear % 400 == 0) {
			return true;
		} else if (baseYear % 100 == 0) {
			return false;
		} else if (baseYear % 4 == 0) {
			return true;
		}
		return false;
	}

}
