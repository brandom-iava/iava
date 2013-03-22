// Source File Name:   DateTimeHelper.java

package com.iava.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeHelper {

	private DateTimeHelper() {
	}

	public static int afterDay(Date dStart, Date dEnd) {
		return after(dStart, dEnd, 0x15180);
	}

	public static int afterHour(Date dStart, Date dEnd) {
		return after(dStart, dEnd, 3600);
	}

	public static int afterMinute(Date dStart, Date dEnd) {
		return after(dStart, dEnd, 60);
	}

	public static int aftersecond(Date dStart, Date dEnd) {
		return after(dStart, dEnd, 1);
	}

	public static String chinaDataFormat(Date dDate) {
		if (dDate == null)
			return null;
		String sDate = toString(dDate, "yyyy-MM-dd");
		String tmpArr[] = sDate.split("-");
		String dArr[] = { "\u96F6", "\u4E00", "\u4E8C", "\u4E09", "\u56DB",
				"\u4E94", "\u516D", "\u4E03", "\u516B", "\u4E5D" };
		for (int i = 0; i < 10; i++) {
			Integer x = new Integer(i);
			String temp = x.toString();
			tmpArr[0] = tmpArr[0].replaceAll(temp, dArr[i]);
		}

		tmpArr[0] = (new StringBuilder(String.valueOf(tmpArr[0]))).append(
				"\u5E74").toString();
		if (tmpArr[1].length() == 1)
			tmpArr[1] = (new StringBuilder(String.valueOf(dArr[Integer
					.parseInt(tmpArr[1])]))).append("\u6708").toString();
		else if (tmpArr[1].substring(0, 1).equals("0")) {
			tmpArr[1] = (new StringBuilder(String.valueOf(dArr[Integer
					.parseInt(tmpArr[1].substring(tmpArr[1].length() - 1,
							tmpArr[1].length()))]))).append("\u6708")
					.toString();
		} else {
			tmpArr[1] = (new StringBuilder("\u5341"))
					.append(dArr[Integer.parseInt(tmpArr[1].substring(
							tmpArr[1].length() - 1, tmpArr[1].length()))])
					.append("\u6708").toString();
			tmpArr[1] = tmpArr[1].replaceAll("\u96F6", "");
		}
		if (tmpArr[2].length() == 1)
			tmpArr[2] = (new StringBuilder(String.valueOf(dArr[Integer
					.parseInt(tmpArr[2])]))).append("\u65E5").toString();
		else if (tmpArr[2].substring(0, 1).equals("0")) {
			tmpArr[2] = (new StringBuilder(String.valueOf(dArr[Integer
					.parseInt(tmpArr[2].substring(tmpArr[2].length() - 1,
							tmpArr[2].length()))]))).append("\u65E5")
					.toString();
		} else {
			tmpArr[2] = (new StringBuilder(String.valueOf(dArr[Integer
					.parseInt(tmpArr[2].substring(0, 1))])))
					.append("\u5341")
					.append(dArr[Integer.parseInt(tmpArr[2].substring(
							tmpArr[2].length() - 1, tmpArr[2].length()))])
					.append("\u65E5").toString();
			tmpArr[2] = tmpArr[2].replaceAll("\u96F6", "");
		}
		return (new StringBuilder(String.valueOf(tmpArr[0]))).append(tmpArr[1])
				.append(tmpArr[2]).toString();
	}

	public static String chinaDataFormat(String sDate) throws Exception {
		return chinaDataFormat(toDate(sDate));
	}

	public static int getDay(Date dDate) {
		return getDateNumber(dDate, 5);
	}

	public static int getDate(Date dDate) {
		return getDateNumber(dDate, 5);
	}

	public static int getHours(Date dDate) {
		return getDateNumber(dDate, 10);
	}

	public static int getMinutes(Date dDate) {
		return getDateNumber(dDate, 12);
	}

	public static int getMonth(Date dDate) {
		return getDateNumber(dDate, 2) + 1;
	}

	public static int getSeconds(Date dDate) {
		return getDateNumber(dDate, 13);
	}

	public static int getYear(Date dDate) {
		return getDateNumber(dDate, 1);
	}

	public static int getYear(String sDate) throws Exception {
		return getDateNumber(toDate(sDate), 1);
	}

	public static int getDayInMonth(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "d"))
				: -8888;
	}

	public static int getDayInMonth(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "d")) : -8888;
	}

	public static int getDayOfWeekInMouth(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "F"))
				: -8888;
	}

	public static int getDayOfWeekInMouth(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "F")) : -8888;
	}

	public static String getDayInWeek(Date dDate) {
		return getFormatDate(dDate, "E");
	}

	public static String getDayInWeek(String sDate) throws Exception {
		return getFormatDate(sDate, "E");
	}

	public static int getDayInYear(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "D"))
				: -8888;
	}

	public static int getDayInYear(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "D")) : -8888;
	}

	public static int getHourInDay(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "H"))
				: -8888;
	}

	public static int getHourInDay(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "H")) : -8888;
	}

	public static int getMinuteInHour(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "m"))
				: -8888;
	}

	public static int getMinuteInHour(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "m")) : -8888;
	}

	public static int getSecondInMinute(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "s"))
				: -8888;
	}

	public static int getSecondInMinute(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "s")) : -8888;
	}

	public static Date getSystemDateTime() {
		return new Date(System.currentTimeMillis());
	}

	public static String getSystemDateTimeString() {
		DateFormat format = new SimpleDateFormat(
				"yyyy\u5E74-MM\u6708-dd\u65E5 HH:mm:ss", localeChina);
		return format.format(getSystemDateTime());
	}

	public static String getFormatDateTimeString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				localeChina);
		return format.format(getSystemDateTime());
	}

	public static int getWeekInonth(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "W"))
				: -8888;
	}

	public static int getWeekInMonth(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "W")) : -8888;
	}

	public static int getWeekInYear(Date dDate) {
		return dDate != null ? Integer.parseInt(getFormatDate(dDate, "w"))
				: -8888;
	}

	public static int getWeekInYear(String sDate) throws Exception {
		return sDate != null && sDate.trim() != "" ? Integer
				.parseInt(getFormatDate(sDate, "w")) : -8888;
	}

	public static boolean isLeapYear(Date dDate) {
		if (dDate == null)
			return false;
		Locale _tmp = localeChina;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		try {
			format.parse(format.format(dDate));
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		format.getCalendar();
		return isLeapYear(1);
	}

	public static boolean isLeapYear(int iYear) {
		if (iYear <= 0) {
			return false;
		} else {
			GregorianCalendar grc = new GregorianCalendar();
			return grc.isLeapYear(iYear);
		}
	}

	public static boolean isLeapYear(String sYear) {
		if (sYear == null || sYear.trim() == "")
			return false;
		else
			return isLeapYear(Integer.parseInt(sYear));
	}

	public static Date relativeDate(Date dDate, int iAfter) {
		return relative(dDate, iAfter, 5);
	}

	public static Date relativeDate(String sDate, int iAfter) throws Exception {
		return relative(toDate(sDate), iAfter, 5);
	}

	public static Date relativeHour(Date dDate, int iAfter) {
		return relative(dDate, iAfter, 10);
	}

	public static Date relativeHour(String sDate, int iAfter) throws Exception {
		return relative(toDate(sDate), iAfter, 10);
	}

	public static Date relativeMonth(Date dDate, int iAfter) {
		return relative(dDate, iAfter, 2);
	}

	public static Date relativeMonth(String sDate, int iAfter) throws Exception {
		return relative(toDate(sDate), iAfter, 2);
	}

	public static Date relative(Date dDate, int iAfter, int iType) {
		if (dDate == null) {
			return null;
		} else {
			GregorianCalendar grc = new GregorianCalendar();
			grc.setTime(dDate);
			grc.add(iType, iAfter);
			return grc.getTime();
		}
	}

	public static Date relative(String sDate, int iAfter, int iType)
			throws Exception {
		return relative(toDate(sDate), iAfter, iType);
	}

	public static Date relativeSecond(Date dDate, int iAfter) {
		return relative(dDate, iAfter, 13);
	}

	public static Date relativeSecond(String sDate, int iAfter)
			throws Exception {
		return relative(toDate(sDate), iAfter, 13);
	}

	public static Date relativeWeek(Date dDate, int iAfter) {
		return relative(dDate, iAfter, 4);
	}

	public static Date relativeWeek(String sDate, int iAfter) throws Exception {
		return relative(toDate(sDate), iAfter, 4);
	}

	public static Date relativeYear(Date dDate, int iAfter) {
		return relative(dDate, iAfter, 1);
	}

	public static Date relativeYear(String sDate, int iAfter) throws Exception {
		return relative(toDate(sDate), iAfter, 1);
	}

	public static Date toDate(String sDate, String sFormat) throws Exception {
		if (sDate.trim().length() == 0 || sDate == null)
			return null;
		if (sFormat == null || sFormat.trim().length() == 0)
			sFormat = "yyyy-MM-dd";
		try {
			DateFormat format = new SimpleDateFormat(sFormat, localeChina);
			return format.parse(sDate);
		} catch (ParseException e) {
			System.out
					.println((new StringBuilder())
							.append(getSystemDateTime())
							.append("--------- DateTimeHelper\u8C03\u7528 toDate\u51FD\u6570\u51FA\u9519 \u9519\u8BEF\u4FE1\u606F\u5982\u4E0B\uFF1A----------")
							.toString());
			System.out.println(e.getMessage());
			System.out.println("---------\u9519\u8BEF\u4FE1\u606F----------");
			throw new Exception((new StringBuilder(
					"\u65E5\u671F\u5B57\u7B26\u683C\u5F0F\u4E0D\u5BF9\u300A"))
					.append(sDate).append("\u300B").append(":")
					.append(e.getMessage()).toString());
		}
	}

	public static Date toDate(String sDate) throws Exception {
		if (sDate.trim().length() == 0 || sDate == null)
			return null;
		String sConvert = sDate.trim();
		String sFormat = null;
		if (sConvert.indexOf("\u5E74") > 0 && sConvert.indexOf("\u6708") > 0
				&& sConvert.indexOf("\u65E5") > 0
				&& sConvert.indexOf("\u65F6") > 0
				&& sConvert.indexOf("\u5206") > 0
				&& sConvert.indexOf("\u79D2") > 0)
			return toDate(sDate,
					"yyyy\u5E74MM\u6708dd\u65E5 HH\u65F6mm\u5206ss\u79D2");
		if (sConvert.indexOf("\u5E74") > 0 && sConvert.indexOf("\u6708") > 0
				&& sConvert.indexOf("\u65E5") > 0 && sConvert.indexOf(":") > 0)
			return toDate(sDate, "yyyy\u5E74MM\u6708dd\u65E5 HH:mm:ss");
		if (sConvert.indexOf("-") > 0 && sConvert.indexOf(":") > 0)
			return toDate(sDate, "yyyy-MM-dd HH:mm:ss");
		if (sConvert.indexOf("/") > 0 && sConvert.indexOf(":") > 0)
			return toDate(sDate, "yyyy/MM/dd HH:mm:ss");
		if (sConvert.indexOf(".") > 0 && sConvert.indexOf(":") > 0)
			return toDate(sDate, "yyyy.MM.dd HH:mm:ss");
		if (sConvert.indexOf("-") > 0)
			sFormat = "yyyy-MM-dd";
		else if (sConvert.indexOf("/") > 0)
			sFormat = "yyyy/MM/dd";
		else if (sConvert.indexOf(".") > 0)
			sFormat = "yyyy.MM.dd";
		else if (sConvert.indexOf("\u5E74") > 0
				&& sConvert.indexOf("\u6708") > 0
				&& sConvert.indexOf("\u65E5") > 0)
			sFormat = "yyyy\u5E74MM\u6708dd\u65E5";
		return toDate(sDate, sFormat);
	}

	public static String toString(Date dDate, String sFormat) {
		if (dDate == null)
			return "";
		if (sFormat == null || sFormat.trim() == "")
			sFormat = "yyyy-MM-dd";
		DateFormat format = new SimpleDateFormat(sFormat, localeChina);
		return format.format(dDate).toString();
	}

	public static String toString(Date dDate) {
		return toString(dDate, "yyyy-MM-dd");
	}

	public static Time toTime(String sTime, String sFormat) {
		if (sTime.trim().length() == 0 || sTime == null)
			return null;
		if (sFormat == null || sFormat.trim().length() == 0)
			sFormat = "HH:mm:ss";
		try {
			DateFormat format = new SimpleDateFormat(sFormat, localeChina);
			return new Time(format.parse(sTime).getTime());
		} catch (ParseException e) {
			System.out
					.println((new StringBuilder())
							.append(getSystemDateTime())
							.append("--------- DateTimeHelper\u8C03\u7528 toDate\u51FD\u6570\u51FA\u9519 \u9519\u8BEF\u4FE1\u606F\u5982\u4E0B\uFF1A----------")
							.toString());
			System.out.println(e.getMessage());
			System.out.println("---------\u9519\u8BEF\u4FE1\u606F----------");
			throw new RuntimeException((new StringBuilder(
					"\u65E5\u671F\u5B57\u7B26\u683C\u5F0F\u4E0D\u5BF9\u300A"))
					.append(sTime).append("\u300B").append(":")
					.append(e.getMessage()).toString());
		}
	}

	public static Time toTime(String sTime) throws Exception {
		if (sTime.trim().length() == 0 || sTime == null)
			return null;
		String sConvert = sTime.trim();
		String sFormat = null;
		if (sConvert.indexOf(":") == -1)
			throw new RuntimeException((new StringBuilder(
					"\u65F6\u95F4\u5B57\u7B26\u683C\u5F0F\u4E0D\u5BF9\u300A"))
					.append(sTime).append("\u300B").toString());
		if (sConvert.matches("\u65F6") && sConvert.matches("\u5206")
				&& sConvert.matches("\u79D2") && sConvert.indexOf(":") > 0
				&& sConvert.indexOf(" ") > 0)
			sFormat = "HH\u65F6mm\u5206ss\u79D2 S";
		else if (sConvert.matches("\u65F6") && sConvert.matches("\u5206")
				&& sConvert.matches("\u79D2")) {
			sFormat = "HH\u65F6mm\u5206ss\u79D2";
		} else {
			if (sConvert.indexOf("\u5E74") > 0 || sConvert.indexOf("-") > 0
					|| sConvert.indexOf("/") > 0 || sConvert.indexOf(".") > 0)
				return new Time(toDate(sConvert).getTime());
			if (sConvert.indexOf(":") > 0
					&& sConvert.indexOf(" ") > sConvert.indexOf(":"))
				sFormat = "HH:mm:ss S";
			else
				try {
					return Time.valueOf(sConvert);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
		}
		return toTime(sConvert, sFormat);
	}

	public static Timestamp toTimestamp(String sTimestamp, String sFormat) {
		if (sTimestamp.trim().length() == 0 || sTimestamp == null)
			return null;
		if (sFormat == null || sFormat.trim().length() == 0)
			sFormat = "yyyy-MM-dd HH:mm:ss";
		try {
			DateFormat format = new SimpleDateFormat(sFormat, localeChina);
			return new Timestamp(format.parse(sTimestamp).getTime());
		} catch (ParseException e) {
			System.out
					.println((new StringBuilder())
							.append(getSystemDateTime())
							.append("--------- DateTimeHelper\u8C03\u7528 toTimestamp\u51FD\u6570\u51FA\u9519 \u9519\u8BEF\u4FE1\u606F\u5982\u4E0B\uFF1A----------")
							.toString());
			System.out.println(e.getMessage());
			System.out.println("---------\u9519\u8BEF\u4FE1\u606F----------");
			throw new RuntimeException((new StringBuilder(
					"\u65E5\u671F\u5B57\u7B26\u683C\u5F0F\u4E0D\u5BF9\u300A"))
					.append(sTimestamp).append("\u300B").append(":")
					.append(e.getMessage()).toString());
		}
	}

	public static Timestamp toTimestamp(String sTimestamp) {
		if (sTimestamp == null || sTimestamp.trim().length() == 0)
			return null;
		String sConvert = sTimestamp.trim();
		String sFormat = null;
		if (sConvert.matches("\u5E74") && sConvert.matches("\u6708")
				&& sConvert.matches("\u65E5") && sConvert.matches("\u65F6")
				&& sConvert.matches("\u5206") && sConvert.matches("\u79D2")
				&& sConvert.lastIndexOf(" ") > sConvert.lastIndexOf("\u79D2"))
			sFormat = "yyyy\u5E74-MM\u6708-dd\u65E5 HH\u65F6mm\u5206ss\u79D2 S";
		else if (sConvert.matches("\u5E74") && sConvert.matches("\u6708")
				&& sConvert.matches("\u65E5") && sConvert.matches("\u65F6")
				&& sConvert.matches("\u5206") && sConvert.matches("\u79D2"))
			sFormat = "yyyy\u5E74-MM\u6708-dd\u65E5 HH\u65F6mm\u5206ss\u79D2";
		if (sConvert.matches("\u5E74") && sConvert.matches("\u6708")
				&& sConvert.matches("\u65E5") && sConvert.matches(":")
				&& sConvert.lastIndexOf(" ") > sConvert.lastIndexOf("\u79D2"))
			sFormat = "yyyy\u5E74-MM\u6708-dd\u65E5 HH:mm:ss S";
		else if (sConvert.matches("\u5E74") && sConvert.matches("\u6708")
				&& sConvert.matches("\u65E5") && sConvert.matches(":"))
			sFormat = "yyyy\u5E74-MM\u6708-dd\u65E5 HH\u65F6mm\u5206ss\u79D2";
		else if (sConvert.indexOf("-") > 0 && sConvert.indexOf(":") > 0
				&& sConvert.lastIndexOf(" ") > sConvert.lastIndexOf(":"))
			sFormat = "yyyy-MM-dd HH:mm:ss S";
		else if (sConvert.indexOf("-") > 0 && sConvert.indexOf(":") > 0) {
			sFormat = "yyyy-MM-dd HH:mm:ss";
			try {
				return Timestamp.valueOf(sConvert);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		} else if (sConvert.indexOf("/") > 0 && sConvert.indexOf(":") > 0
				&& sConvert.lastIndexOf(" ") > sConvert.lastIndexOf(":"))
			sFormat = "yyyy/MM/dd HH:mm:ss S";
		else if (sConvert.indexOf("/") > 0 && sConvert.indexOf(":") > 0
				&& sConvert.lastIndexOf(" ") > sConvert.lastIndexOf(":"))
			sFormat = "yyyy/MM/dd HH:mm:ss";
		else if (sConvert.indexOf(".") > 0 && sConvert.indexOf(":") > 0
				&& sConvert.lastIndexOf(" ") > sConvert.lastIndexOf(":"))
			sFormat = "yyyy.MM.dd HH:mm:ss S";
		else if (sConvert.indexOf(".") > 0 && sConvert.indexOf(":") > 0)
			sFormat = "yyyy.MM.dd HH:mm:ss";
		return toTimestamp(sConvert, sFormat);
	}

	private static int after(Date dStart, Date dEnd, int iType) {
		if (dStart == null || dEnd == null) {
			return -8888;
		} else {
			Calendar calendar = Calendar.getInstance(Locale.CHINA);
			calendar.setTime(dStart);
			long lStart = calendar.getTimeInMillis();
			calendar.setTime(dEnd);
			long lEnd = calendar.getTimeInMillis();
			return Integer.parseInt(Long.toString((lEnd - lStart)
					/ (long) (iType * 1000)));
		}
	}

	private static int getDateNumber(Date dDate, int iType) {
		if (dDate == null) {
			return -8888;
		} else {
			Calendar calendar = Calendar.getInstance(Locale.CHINA);
			calendar.setTime(dDate);
			return calendar.get(iType);
		}
	}

	private static String getFormatDate(Date dDate, String sFormat) {
		if (dDate == null || sFormat == null || sFormat.trim() == "") {
			return null;
		} else {
			DateFormat format = new SimpleDateFormat(sFormat, localeChina);
			return format.format(dDate);
		}
	}

	private static String getFormatDate(String sDate, String sFormat)
			throws Exception {
		if (sDate == null || sDate.trim() == "" || sFormat == null
				|| sFormat.trim() == "") {
			return null;
		} else {
			DateFormat format = new SimpleDateFormat(sFormat, localeChina);
			return format.format(toDate(sDate));
		}
	}

	private static Locale localeChina;
	private static String day_Of_The_Week[] = { "Sunday", "Monday", "Tuesday",
			"Wednesday", "Thursday", "Friday", "Saturday" };
	private static String day_Of_The_Week_China[] = { "������", "����һ", "���ڶ�",
			"������", "������", "������", "������" };

	static {
		localeChina = Locale.CHINA;
	}
}
