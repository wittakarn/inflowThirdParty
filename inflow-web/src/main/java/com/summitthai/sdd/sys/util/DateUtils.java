package com.summitthai.sdd.sys.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;

/**
 * * Copyright (c) 2002-2005 Summit Computer Co., Ltd.
 * 109 Surawong Road, Bangruk, Bangkok, 10500, Thailand.
 * All Rights Reserved.
 * @version 1.0
 */

public class DateUtils {
	
//    private static final int BUDDHIST_YEAR = 0;
    private static final int BUDDHIST_YEAR = 543;

    public static void main(String[] args) {
//    	System.out.println(compareDateString("25520815", "25530923"));
//    	System.out.println(compareDateString("25520815", "25520815"));
//    	System.out.println(compareDateString("25530815", "25530623"));
//		System.out.println(compareDateString("null", "25530723"));
//		System.out.println(compareDateString("25530815", null));
//		System.out.println(compareDateString("25530815", ""));
//    	System.out.println(dateTimeDiff("1"));
//    	System.out.println(toDateChristEra("25540607"));
//    	Calendar c = toCalendar("20070101120500");
    	System.out.println(getCurrentDateString());
    	System.out.println(toStringDate(new Date()));
    	System.out.println(getCurrentDateTimeString());
    	System.out.println(DateUtils.displayFullDate("20070101", "T").replace(" เดือน", ""));
//    	System.out.println(toTimestamp(getCurrentDateTimeString()));
//    	System.out.println(toStringDateTime(toTimestamp(getCurrentDateTimeString())));
    }

    /**
     * @return Calendar
     * @example Calendar date = DateUtils.getCurrentDateCalendarEng();
     */
    public static Calendar getCurrentDateCalendarEng() {
        return Calendar.getInstance(Locale.US);
    }
	
    /**
     * @return String ("20130101")
     * @example String dateUI = DateUtils.getCurrentDateStringEng();
     */
    public static String getCurrentDateString() {
        Calendar calendar = Calendar.getInstance(Locale.US);
        return DateUtils.toStringDate(calendar);
    }
    
    /**
     * @return String ("25560101")
     * @example String dateUI = DateUtils.getCurrentDateStringEng();
     */
    public static String getCurrentDateThaiString() {
        Calendar calendar = Calendar.getInstance(Locale.US);
        return DateUtils.toStringDate(calendar);
    }
	
    /**
     * @return String ("20130116153112")
     * @example String dateUI = DateUtils.getCurrentDateTimeString();
     */
    public static String getCurrentDateTimeString() {
        Calendar calendar = Calendar.getInstance(Locale.US);
        return DateUtils.toStringDateTime(calendar);
    }

    /**
     * @param date ex:01/01/2013
     * @return String ex:20130101
     */
    public static String toDb(String date) {
        if (date != null) {
            if (date.length() == 10) {
                return date.substring(6, 10) + date.substring(3, 5) + date.substring(0, 2);
            }
        }
        return date;
    }
  
    /**
     * @param yyyymmddhhmmss ex. "20070101120500" , "20530101120500"
     * @return Calendar
     * @example Calendar c = DateUtils.convertStringDateTimeToCalendar("20070101120500");
     */
    public static Calendar toCalendar(String yyyymmddhhmmss) {
        int year = Integer.parseInt(yyyymmddhhmmss.substring(0, 4));
        if (year > 2400) {
            year = year - 543;
        }
        int month = Integer.parseInt(yyyymmddhhmmss.substring(4, 6)) - 1;
        int day = Integer.parseInt(yyyymmddhhmmss.substring(6, 8));
        int hh = Integer.parseInt(yyyymmddhhmmss.substring(8, 10));
        int mm = Integer.parseInt(yyyymmddhhmmss.substring(10, 12));
        int ss = Integer.parseInt(yyyymmddhhmmss.substring(12, 14));
        Calendar date = Calendar.getInstance(Locale.US);        
        date.set(year, month, day, hh, mm, ss);
        return date;
    }
    
    /**
     * @param yyyymmddhhmmss ex. "20070101120500" , "20530101120500"
     * @return Timestamp
     */
    public static Timestamp toTimestamp(String yyyymmddhhmmss) {
        if (yyyymmddhhmmss == null) {
            return null;
        }
        String year = yyyymmddhhmmss.substring(0, 4);
        if (Integer.valueOf(year) > 2400) {
            year = String.valueOf(Integer.parseInt(year) - 543);
        }
        String month = yyyymmddhhmmss.substring(4, 6);
        String day = yyyymmddhhmmss.substring(6, 8);
        String hour = "";
        String minute = "";
        String second = "";

        if (yyyymmddhhmmss.length() == 8) {
            hour = "00";
            minute = "00";
            second = "00";
        } else if(yyyymmddhhmmss.length() == 12){
        	hour = yyyymmddhhmmss.substring(8, 10);
            minute = yyyymmddhhmmss.substring(10, 12);
        	second = "00";
        } else {
            hour = yyyymmddhhmmss.substring(8, 10);
            minute = yyyymmddhhmmss.substring(10, 12);
            second = yyyymmddhhmmss.substring(12, 14);
        }
        return Timestamp.valueOf(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + ".0");
    }

    /**
     * @param date
     * @return String ("25560101")
     */
    public static String toStringDate(Date date) {
    	
    	Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.setTimeZone(TimeZone.getTimeZone("Asia/Bangkok"));
		calendar.setTime(date);
    	
        String yyyy = String.valueOf(calendar.get(Calendar.YEAR) + BUDDHIST_YEAR);
        String mm = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        if (mm.length() < 2) mm = "0" + mm;
        if (dd.length() < 2) dd = "0" + dd;
        return yyyy + mm + dd;
    }

    /**
     * @param calendar
     * @return String ("20130101")
     * @example String dateUI = DateUtils.convertCalendarToStringDate( DateUtils.getCurrentDateCalendarEng() );
     */
    public static String toStringDate(Calendar calendar) {
        String yyyy = String.valueOf(calendar.get(Calendar.YEAR) + BUDDHIST_YEAR);
        String mm = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        if (mm.length() < 2) mm = "0" + mm;
        if (dd.length() < 2) dd = "0" + dd;
        return yyyy + mm + dd;
    }

    /**
     * @param timestamp
     * @return String ("20130101")
     */
    public static String toStringDate(Timestamp timestamp) {
        if (timestamp != null) {
            String timestampString = timestamp.toString();

            String year = String.valueOf(Integer.parseInt(timestampString.substring(0, 4)) + BUDDHIST_YEAR);
            String month = timestampString.substring(5, 7);
            String day = timestampString.substring(8, 10);

            return year + month + day;
        } else {
            return null;
        }
    }
    
	/**
	 * @param _long
	 * @return String ("20130101010101")
	 */
	public static String toStringDateTime(long _long) {
		Calendar c = Calendar.getInstance(Locale.US);
		c.setTimeInMillis(_long);
		return toStringDateTime(c);
	}

    /**
     * @param calendar
     * @return String ("20130101010101")
     * @example String dateUI = DateUtils.convertCalendarToStringDateTime( DateUtils.getCurrentDateCalendarEng() );
     */
    public static String toStringDateTime(Calendar calendar) {
    	String yyyy = String.valueOf(calendar.get(Calendar.YEAR) + BUDDHIST_YEAR);
        String mm = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String hh = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String nn = String.valueOf(calendar.get(Calendar.MINUTE));
        String ss = String.valueOf(calendar.get(Calendar.SECOND));
        if (mm.length() < 2) mm = "0" + mm;
        if (dd.length() < 2) dd = "0" + dd;
        if (hh.length() < 2) hh = "0" + hh;
        if (nn.length() < 2) nn = "0" + nn;
        if (ss.length() < 2) ss = "0" + ss;

        return yyyy + mm + dd + hh + nn + ss;
    }

    /**
     * @param timestamp
     * @return String ("20130101010101")
     */
    public static String toStringDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            String timestampString = timestamp.toString();

            String year = String.valueOf(Integer.parseInt(timestampString.substring(0, 4)) + BUDDHIST_YEAR);
            String month = timestampString.substring(5, 7);
            String day = timestampString.substring(8, 10);
            String hour = timestampString.substring(11, 13);
            String minute = timestampString.substring(14, 16);
            String second = timestampString.substring(17, 19);

            return year + month + day + hour + minute + second;
        } else {
            return null;
        }
    }

    /**
     * @param calendar
     * @return String ("20130101010101001")
     * @example String dateUI = DateUtils.convertCalendarToStringDateTimeMillisecond( DateUtils.getCurrentDateCalendarEng() );
     */
    public static String toStringDateTimeMillisecond(Calendar calendar) {
        String yyyy = String.valueOf(calendar.get(Calendar.YEAR) + BUDDHIST_YEAR);
        String mm = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String hh = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String nn = String.valueOf(calendar.get(Calendar.MINUTE));
        String ss = String.valueOf(calendar.get(Calendar.SECOND));
        String ms = String.valueOf(calendar.get(Calendar.MILLISECOND));
        if (mm.length() < 2) mm = "0" + mm;
        if (dd.length() < 2) dd = "0" + dd;
        if (hh.length() < 2) hh = "0" + hh;
        if (nn.length() < 2) nn = "0" + nn;
        if (ss.length() < 2) ss = "0" + ss;
        if (ms.length() == 1) {
            ms = "00" + ms;
        } else if (ms.length() == 2) {
            ms = "0" + ms;
        }

        return yyyy + mm + dd + hh + nn + ss + ms;
    }

    /**
     * @param calendar
     * @return String ("201301")
     * @example String yearMonth = DateUtils.convertCalendarToStringyearmonth( DateUtils.getCurrentDateCalendarEng() );
     */
    public static String toStringYearMonth(Calendar calendar) {
        String yyyy = String.valueOf(calendar.get(Calendar.YEAR) + BUDDHIST_YEAR);
        String mm = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        if (mm.length() < 2) mm = "0" + mm;
        return yyyy + mm;
    }
  
    /**
     * @param calendar ex:2007/01/06
     * @param day number of next ex:5
     * @return Calendar ex:2007/01/01
     * @example Calendar nextDate = DateUtils.getPreviousDay( DateUtils.getCurrentDateCalendarEng(), 5 );
     */
    public static Calendar getPreviousDay(Calendar calendar, int day) {
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - day);
        return calendar;
    }

    /**
     * @param calendar ex:2007/01/01
     * @param day number of next ex:5
     * @return Calendar ex:2007/01/06
     * @example Calendar nextDate = DateUtils.getNextDay( DateUtils.getCurrentDateCalendarEng(), 5 );
     */
    public static Calendar getNextDay(Calendar calendar, int day) {
        Calendar nextDay = (Calendar)calendar.clone();
        nextDay.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + day);
        return nextDay;
    }

    /**
     * @param calendar ex:2007/01/01
     * @param month number of next month ex:5
     * @return Calendar ex:2007/05/01
     * @example Calendar nextDate = DateUtils.getNextMonth( DateUtils.getCurrentDateCalendarEng(), 5 );
     */
    public static Calendar getNextMonth(Calendar calendar, int month) {
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
        return calendar;
    }

    /**
     * @param calendar  ex:2007/01/01
     * @return Calendar ex:2008/01/01
     * @example Calendar nextDate = DateUtils.getNextYear( DateUtils.getCurrentDateCalendarEng(), 1 );
     */
    public static Calendar getNextYear(Calendar calendar, int i) {
        int year = Integer.parseInt(toStringDate(calendar).substring(0, 4)) + i;
        int month = Integer.parseInt(toStringDate(calendar).substring(4, 6)) - 1;
        int day = Integer.parseInt(toStringDate(calendar).substring(6, 8));
        Calendar date = Calendar.getInstance(Locale.US);
        date.set(year, month, day);
        return date;
    }

    /**
     * function use fine date next year
     * @param startDate   "20080423" , "25530423" 
     * @param years       1
     * @return stringDate 20130423
     */
    public static String getNextYear(String startDate, Long years) {
        Calendar calendar = null;
        String stringDate = null;
        try {
            if ((!StringUtils.isNullOrEmpty(startDate)) && (years != null)) {
            	int year = Integer.parseInt(startDate.substring(0, 4));
                if (year > 2400) {
                    year = year - 543;
                }
                calendar = toCalendar(String.valueOf(year) + startDate.substring(4, 8) + "000000");
                calendar = getNextYear(calendar, years.intValue());
                stringDate = toStringDate(calendar);
            }
        } finally {
            calendar = null;
        }

        return stringDate;
    }

    /**
     * @return int (day of week 1 = SUNDAY , ... 7 = SATURDAY)
     * @example int day = DateUtils.getDayOfWeek()
     */
    public static int getDayOfWeek() {
        Calendar date = Calendar.getInstance(Locale.US);
        return date.get(Calendar.DAY_OF_WEEK);
    }
    
    /**
     * @return int (day of week 1 = SUNDAY , ... 7 = SATURDAY)
     * @example int day = DateUtils.getDayOfWeek(String date)
     * @parameter yyyymmddhhmmss ex. "20070101120500" , "20530101120500"
     */
    public static int getDayOfWeek(Calendar date) {
        return date.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @param yyyymmdd String
     * @return int (day) ex:1
     * @example int day = DateUtils.getDay("20070101");
     */
    public static int getDay(String yyyymmdd) {
        int day = Integer.parseInt(yyyymmdd.substring(6, 8));
        return day;
    }

    /**
     * @param yyyymmdd String
     * @return int (month) ex:1
     * @example int month = DateUtils.getMonth("20070101");
     */
    public static int getMonth(String yyyymmdd) {
        int month = Integer.parseInt(yyyymmdd.substring(4, 6));
        return month;
    }

    /**
     * @param yyyymmdd String "20130101"
     * @return int (year) "2013"
     * @example int year = DateUtils.getYear("20130101");
     */
    public static int getYear(String yyyymmdd) {
        int year = Integer.parseInt(yyyymmdd.substring(0, 4));
        return year;
    }

    /**
     * @param calendar Calendar
     * @return int (year) "2013"
     * @example int year = DateUtils.getYear( DateUtils.getCurrentDateCalendarEng() );
     */
    public static int getYear(Calendar calendar) {
        String date = DateUtils.toStringDate(calendar);
        int year = Integer.parseInt(date.substring(0, 4));
        return year;
    }

    /**
     * @param timeStamp TimeStamp
     * @return int (year) "2013"
     * @example int year = DateUtils.getYear( Object TimeStamp );
     */
    public static int getYear(Timestamp timeStamp) {
        Calendar c = Calendar.getInstance(Locale.US);
        c.setTimeInMillis(timeStamp.getTime());
        return c.get(Calendar.YEAR) + BUDDHIST_YEAR;
    }

    /**
     * @param beginDateBase "20100101" , "25530101"
     * @param endDateBase "20100110" , "25530110"
     * @return int 9
     * @example int dateDiff = DateUtils.countDiffDay("20130101", "20130110");
     */
    public static int countDiffDay(String beginDateBase, String endDateBase) {
        Calendar beginDate = Calendar.getInstance(Locale.US);
        Calendar endDate = Calendar.getInstance(Locale.US);

        int year, month, date;

        year = Integer.valueOf(beginDateBase.substring(0, 4)).intValue();
        if (year > 2400) {
            year = year - 543;
        }
        month = Integer.valueOf(beginDateBase.substring(4, 6)).intValue() - 1;
        date = Integer.valueOf(beginDateBase.substring(6, 8)).intValue();

        beginDate.set(year, month, date);

        year = Integer.valueOf(endDateBase.substring(0, 4)).intValue();
        if (year > 2400) {
            year = year - 543;
        }
        month = Integer.valueOf(endDateBase.substring(4, 6)).intValue() - 1;
        date = Integer.valueOf(endDateBase.substring(6, 8)).intValue();

        endDate.set(year, month, date);

        return (countDiffDay(beginDate, endDate));
    }

    public static int countDiffDay(Calendar beginDate, Calendar endDate) {
        int returnInt = 0;

        while (!beginDate.after(endDate)) {
            beginDate.add(Calendar.DAY_OF_MONTH, 1);
            returnInt++;
        }
        if (returnInt > 0) {
            returnInt = returnInt - 1;
        }

        return (returnInt);
    }

	public static int countDiffMonth(Calendar cBegin, Calendar cEnd, boolean isRoundUp) {
		int diffMonth = 0;
		int dBegin    = 0;
		int dEnd      = 0;
		int mBegin    = 0;
	    int mEnd      = 0;
		try {			
			dBegin = cBegin.get(Calendar.DATE);
			dEnd   = cEnd.get(Calendar.DATE);
			mBegin = (cBegin.get(Calendar.YEAR) * 12) + cBegin.get(Calendar.MONTH);
		    mEnd   = (cEnd.get(Calendar.YEAR) * 12) + cEnd.get(Calendar.MONTH);
		    
		    diffMonth = mEnd - mBegin;
		    if (!isRoundUp) {
		    	return diffMonth;
		    }
		    if (dEnd > dBegin) {
		    	if (diffMonth >= 0) {
			    	diffMonth++;
		    	} else {
			    	diffMonth--;
		    	}
		    }
		    return diffMonth;
		} finally {
			
		}
	}
    
    /**
    *
    * @param date type String syntax => YYYYMMDDhhmmss<br>
    * @return D/M/YYYY h:m:s.
    */
   public static String displayDateTime(String _date) {
       int date = 0;
       int month = 0;
       int year = 0;
       int hour = 0;
       int minute = 0;
       int second = 0 ;
       try {
           if (_date == null || _date.equals("")) {
               return null;
           }
           date = NumberUtils.parseInt(_date.substring(6,8));
           month = NumberUtils.parseInt(_date.substring(4, 6));
           year = NumberUtils.parseInt(_date.substring(0, 4));
           hour = NumberUtils.parseInt(_date.substring(8,10));
           minute = NumberUtils.parseInt(_date.substring(10,12));
           second = NumberUtils.parseInt(_date.substring(12));

           if (year < 2440) {
               year += 543;
           }
           return date + "/" + month + "/" + year +" " + hour + ":" + minute + ":" + second;
       } catch (Exception e) {
    	   e.printStackTrace();
           return null;
       }
   }
   
   /**
   *
   * @param date type String syntax => YYYYMMDDhhmmss<br>
   * @return DD/MM/YYYY hh:mm:ss.
   */
  public static String displayFullDateTime(String _date) {
      String date;
      String month;
      int year;
      String hour;
      String minute;
      String second;
      try {
          if (_date == null || _date.equals("")) {
              return null;
          }
          date = StringUtils.padLeft(NumberUtils.parseInt(_date.substring(6,8)), "0", 2);
          month = StringUtils.padLeft(NumberUtils.parseInt(_date.substring(4, 6)), "0", 2);
          year = NumberUtils.parseInt(_date.substring(0, 4));
          hour = StringUtils.padLeft(NumberUtils.parseInt(_date.substring(8,10)), "0", 2);
          minute = StringUtils.padLeft(NumberUtils.parseInt(_date.substring(10,12)), "0", 2);
          second = StringUtils.padLeft(NumberUtils.parseInt(_date.substring(12)), "0", 2);

          if (year < 2440) {
              year += 543;
          }
          return date + "/" + month + "/" + year +" " + hour + ":" + minute + ":" + second;
      } catch (Exception e) {
   	   e.printStackTrace();
          return null;
      }
  }
   
   /**
   *
   * @param time type String syntax => hhmm<br>
   * @return hh:mm.
   */
  public static String displayTime(String _time) {      
	  try {
          if (_time == null || _time.equals("")) {
              return null;
          }
          String hour   = _time.substring(0, 2);
          String minute = _time.substring(2, 4);

          return hour + ":" + minute;
      } catch (Exception e) {
   	      e.printStackTrace();
          return null;
      }
  }
	
    /**
     * @return String ("2556-01-01 01:01:01:01")
     * @example String dateUI = displayCurrentDateTimeMillisecondString();
     */
    public static String displayCurrentDateTimeMillisecondString() {
        Calendar calendar = Calendar.getInstance(Locale.US);
        int year = calendar.get(Calendar.YEAR);
        if (year < 2440) {
            year += 543;
        }
        String yyyy = String.valueOf(year);
        String mm   = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd   = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String hh   = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String nn   = String.valueOf(calendar.get(Calendar.MINUTE));
        String ss   = String.valueOf(calendar.get(Calendar.SECOND));
        String ms   = String.valueOf(calendar.get(Calendar.MILLISECOND));
        if (mm.length() < 2) mm = "0" + mm;
        if (dd.length() < 2) dd = "0" + dd;
        if (hh.length() < 2) hh = "0" + hh;
        if (nn.length() < 2) nn = "0" + nn;
        if (ss.length() < 2) ss = "0" + ss;
        if (ms.length() == 1) {
            ms = "00" + ms;
        } else if (ms.length() == 2) {
            ms = "0" + ms;
        }

        return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + nn + ":" + ss + ":" + ms;
    }

    /**
     * @return String ("2556-01-01 01:01:01")
     * @example String dateUI = getCurrentDateTimeString();
     */
    public static String displayCurrentDateTimeString() {
        Calendar calendar = Calendar.getInstance(Locale.US);
        int year = calendar.get(Calendar.YEAR);
        if (year < 2440) {
            year += 543;
        }
        String yyyy = String.valueOf(year);
        String mm   = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd   = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String hh   = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String nn   = String.valueOf(calendar.get(Calendar.MINUTE));
        String ss   = String.valueOf(calendar.get(Calendar.SECOND));
        if (mm.length() < 2) mm = "0" + mm;
        if (dd.length() < 2) dd = "0" + dd;
        if (hh.length() < 2) hh = "0" + hh;
        if (nn.length() < 2) nn = "0" + nn;
        if (ss.length() < 2) ss = "0" + ss;

        return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + nn + ":" + ss;
    }

    /**
     * @param timestamp
     * @return String ("2556/01/01 01:01:01")
     * @example String date = getCurrentDateTimeString( timestamp );
     */
    public static String displayTimestampString(Timestamp timestamp) {
        if (timestamp != null) {
            String timestampString = timestamp.toString();

            int yyyy = Integer.parseInt(timestampString.substring(0, 4));
            if (yyyy < 2440) {
                yyyy += 543;
            }
            String year   = String.valueOf(yyyy);
            String month  = timestampString.substring(5, 7);
            String day    = timestampString.substring(8, 10);
            String hour   = timestampString.substring(11, 13);
            String minute = timestampString.substring(14, 16);
            String second = timestampString.substring(17, 19);

            return year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
        } else {
            return null;
        }
    }

    /**
     * @param yyyymmdd "20130101"
     * @return String ("01/01/2556")
     * @example String c = DateUtils.displayDate("20130101");
     */
    public static String displayDate(String yyyymmdd) {
        int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
        if (yyyy < 2440) {
        	yyyy += 543;
        }
        String year  = String.valueOf(yyyy);
        String month = yyyymmdd.substring(4, 6);
        String day   = yyyymmdd.substring(6, 8);

        return day + "/" + month + "/" + year;
    }

    /**
     * @param yyyymmdd "20070101"
     * @param local ex:"E" or "T" (Year)
     * @return String ("01/01/2010" , "01/01/2007")
     * @example String c = DateUtils.displayDate("20070101", "T");
     */
    public static String displayDate(String yyyymmdd, String local) {
        String year = "";
        if (local.equals("E")) {
            year = yyyymmdd.substring(0, 4);
        } else {
            year = String.valueOf(Integer.parseInt(yyyymmdd.substring(0, 4)) + 543);
        }
        String month = yyyymmdd.substring(4, 6);
        String day = yyyymmdd.substring(6, 8);

        return day + "/" + month + "/" + year;
    }

    /**
     * @param yyyymmdd "20070101"
     * @param local ex:"E" or "T" (Year)
     * @return String ("01 เดือน มกราคม พ.ศ.2550")
     * @example String c = DateUtils.displayDate("20070101", "T");
     */
    public static String displayFullDate(String yyyymmdd, String local) {
        String date = "";
        if (yyyymmdd != null) {
            if (yyyymmdd.length() == 8) {
                String year = yyyymmdd.substring(0, 4);
                String month = yyyymmdd.substring(4, 6);
                String day = yyyymmdd.substring(6, 8);
                if (local.equals("E")) {
                    date = getFullMonth(month, local) + " " + Integer.valueOf(day) + ", " + year;
                } else {
                    date = Integer.valueOf(day) + " เดือน " + getFullMonth(month, local) + " พ.ศ." + (Integer.valueOf(year) + BUDDHIST_YEAR);
                }
            }
        }
        return date;
    }

    /**
     * @param month ex:"01"
     * @param local ("E" or "T") ex:"T"
     * @return String ex:"มกราคม"
     * @example String c = DateUtils.displayDate("01", "T");
     */
    public static String getFullMonth(String month, String local) {
        Hashtable<String, String> tblMonth = new Hashtable<String, String>();
        if (local.equals("E")) {
            tblMonth.put("01", "January");
            tblMonth.put("02", "February");
            tblMonth.put("03", "March");
            tblMonth.put("04", "April");
            tblMonth.put("05", "May");
            tblMonth.put("06", "June");
            tblMonth.put("07", "July");
            tblMonth.put("08", "September");
            tblMonth.put("09", "October");
            tblMonth.put("10", "September");
            tblMonth.put("11", "November");
            tblMonth.put("12", "December");
        } else {
            tblMonth.put("01", "มกราคม");
            tblMonth.put("02", "กุมภาพันธ์");
            tblMonth.put("03", "มีนาคม");
            tblMonth.put("04", "เมษายน");
            tblMonth.put("05", "พฤษภาคม");
            tblMonth.put("06", "มิถุนายน");
            tblMonth.put("07", "กรกฎาคม");
            tblMonth.put("08", "สิงหาคม");
            tblMonth.put("09", "กันยายน");
            tblMonth.put("10", "ตุลาคม");
            tblMonth.put("11", "พฤศจิกายน");
            tblMonth.put("12", "ธันวาคม");
        }
        return tblMonth.get(month).toString();
    }

    public static String timeDiff(String currentTime, String startTime) {
        if (currentTime == null || startTime == null) {
            return "00:00:00";
        }
        Calendar calenndarCurrentTime = toCalendar(currentTime);
        Calendar calenndarStartTime = toCalendar(startTime);
        return timeDiff(calenndarCurrentTime, calenndarStartTime);
    }

    public static String timeDiff(Calendar calenndarCurrentTime,
                                  Calendar calenndarStartTime) {

        long startTime = calenndarStartTime.getTimeInMillis();
        long currentTime = calenndarCurrentTime.getTimeInMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        long elapsed = currentTime - startTime;

        return dateFormat.format(new Date(elapsed));
    }

    public static String dateTimeDiff(String timeSecond) {

    	String returnInterval		= "";
    	
        try {
        	Long secondTime			= Long.parseLong(timeSecond);
        	Long second				= secondTime % 60;
        	Long minuitTime			= secondTime / 60;
        	Long minuit				= minuitTime % 60;
        	Long hourTime			= minuitTime / 60;
        	Long hour				= hourTime % 24;
        	Long dayTime			= hourTime / 24;
        	Long day				= dayTime % 24;
        	
        	if(!day.equals(0L)){
        		returnInterval += day + " วัน ";
        	}
        	if(!hour.equals(0L)){
        		returnInterval += hour + " ชั่วโมง ";
        	}
        	if(!minuit.equals(0L)){
        		returnInterval += minuit + " นาที ";
        	}
			if(!second.equals(0L)){
				returnInterval += second + " วินาที";
			}

        	return returnInterval;
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        	return "";
        }
        
    }

    /**
     * @param beginDateTimeBase ex:20090115163153
     * @param endDateBase ex:20090119
     * @return int ex: 3days 7hours 29minutes
     * @example String readyEscalation = DateUtils.getWFEscalationDay("20090115163153", "20090119");
     */
    public static String getWFEscalationDay(String beginDateTimeBase, String endDateBase) {
        String beginDateBase = beginDateTimeBase.substring(0, 8);
        String startHour = beginDateTimeBase.substring(8, 10);
        String startMinute = beginDateTimeBase.substring(10, 12);

        int diffDay = countDiffDay(beginDateBase, endDateBase) - 1;
        int diffHour = 23 - Integer.valueOf(startHour).intValue();
        int diffMinute = 60 - Integer.valueOf(startMinute).intValue();

        // เช็คเผื่อเวลา มีนาทีเป็น .00 ให้ทำการ + ชม.เข้าไปแทน
        if (diffMinute == 60) {
            diffHour = diffHour + 1;
            diffMinute = 0;
        }

        // เช็คเผื่อเวลา มีชม.เป็น 00.00 ให้ทำการ + วันเข้าไปแทน
        if (diffHour == 24) {
            diffDay = diffDay + 1;
            diffHour = 0;
        }

        if (beginDateBase.equals(endDateBase)) {
            diffDay = 0;
            diffHour = 0;
            diffMinute = 0;
        }

        return diffDay + "days " + diffHour + "hours " + diffMinute + "minutes";
    }
    
    /**
     * @param deadlineDateBase ex:20090119
     * @return int ex: 3days 7hours 29minutes
     * @example String readyEscalation = DateUtils.getWFEscalationDay("20090119");
     */
    public static String getWFEscalationDay(String deadlineDateBase) {
      return getWFEscalationDay(toStringDateTime(Calendar.getInstance(Locale.US)), deadlineDateBase);
    }
    
    
    /**
	 * เปรียบเทียบ วันที่  dateBegin, dateEnd
	 * ถ้า  dateBegin เท่ากับ dateEnd return 0
	 * ถ้า  dateBegin มากกว่า dateEnd return 1
	 * ถ้า  dateBegin น้อยกว่า dateEnd return -1
	 * ถ้า Error return 2
	 * @param dateBegin YYYYMMDD
	 * @param dateEnd   YYYYMMDD
	 * @return int 0, 1, -1
	 */
    public static int compareDateString(String dateBegin, String dateEnd) {
    	int value = 2;
    	try {
        	if (dateBegin != null && dateEnd != null) {
            	if (Integer.parseInt(dateBegin) == Integer.parseInt(dateEnd)) {
            		value = 0;
            	} else if (Integer.parseInt(dateBegin) > Integer.parseInt(dateEnd)) {
            		value = 1;
            	} else {
            		value = -1;
            	}
        	}
        	return value;
    	} catch (Exception e) {
        	return 2;
		}
    }
    
    /**
     * ลบ DateTime
     * @param dateTimeBegin (20130101102030)
     * @param dateTimeEnd   (20130101102031)
     * @return Long (วินาที)
     */
    public static Long diffDateTime(String dateTimeBegin, String dateTimeEnd) {
    	long  millisBegin   = 0l;
    	long  millisEnd     = 0l;
    	Long  secondDiff    = null;
    	try {
        	if (dateTimeBegin != null && dateTimeEnd != null) {
        		millisBegin = DateUtils.toCalendar(dateTimeBegin).getTimeInMillis();
        		millisEnd   = DateUtils.toCalendar(dateTimeEnd).getTimeInMillis();
        		
        		secondDiff  = (millisEnd - millisBegin) / 1000l;
        	}
        	return secondDiff;
    	} catch (Exception e) {
    		return null;
		} finally {
			secondDiff      = null;
		}
    }
    
    /**
	 * @param -
	 * @return String ("20070101010101001")
	 * @example String dateUI = getCurrentDateTimeStringMillisecond();
	 */
	public static String getCurrentDateTimeMillisecondString(){  
		Calendar calendar = Calendar.getInstance(Locale.US);
		String yyyy	=	String.valueOf(calendar.get(Calendar.YEAR));
		String mm	=	String.valueOf(calendar.get(Calendar.MONTH)+1);
		String dd	=	String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String hh	=	String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		String nn	=	String.valueOf(calendar.get(Calendar.MINUTE));
		String ss	=	String.valueOf(calendar.get(Calendar.SECOND));
		String ms	=	String.valueOf(calendar.get(Calendar.MILLISECOND));
		if (mm.length() < 2) mm = "0"+mm;
		if (dd.length() < 2) dd = "0"+dd;
		if (hh.length() < 2) hh = "0"+hh;
		if (nn.length() < 2) nn = "0"+nn;
		if (ss.length() < 2) ss = "0"+ss;
		if (ms.length() == 1){
			ms = "00"+ms;
		}else if (ms.length() == 2){
			ms = "0"+ms;
		}
		
		return yyyy + mm + dd + hh + nn + ss + ms;
	}
    
    /** @param dateToValidate:"20120232", dateFromat:"yyyyMMdddd"
     ** 
     ** @return if valid return true else return false
     */
    public static boolean isThisDateValid(String dateToValidate, String dateFormat){
    	 
		if(dateToValidate == null){
			return false;
		}
 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
 
		try {
 
			sdf.parse(dateToValidate);
 
		} catch (ParseException e) {
			return false;
		}
 
		return true;
	}
	
	// -----------------------------------------------------------------------------------------
    //	CRUFLSCC.java --------------------------------------------------------------------------
 
    private static final String[] m1 = {"ม.ค.","ก.พ.","มี.ค.","เม.ย.",
        "พ.ค.","มิ.ย.","ก.ค.","ส.ค.",
        "ก.ย.","ต.ค.","พ.ย.","ธ.ค."};
    private static final String[] m2 = {"มกราคม","กุมภาพันธ์","มีนาคม","เมษายน",
        "พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม",
        "กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"};

    public static String SccUtilDateToThaiDate(Date i_date, int f_outDate, int f_outMouth, int f_outYear) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i_date.getTime());
        String strDate = String.valueOf(c.get(Calendar.YEAR)) +
                paddingString(String.valueOf(c.get(Calendar.MONTH) + 1),2,'0',true) +
                paddingString(String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1),2,'0',true);
        return doProcess(strDate,f_outDate,f_outMouth,f_outYear);
    }

    public static String SccUtilStringDateToThaiDate(String i_date, int f_outDate, int f_outMouth, int f_outYear) {
        return doProcess(i_date,f_outDate,f_outMouth,f_outYear);
    }

    private static String doProcess(String i_date, int f_outDate, int f_outMouth, int f_outYear) {
        String in = "";
        String out = "";
        if (i_date == null) {
            in = "";
        }else {
            in = i_date.trim();
        }
        if (in.equals("") || in.length() != 8) {
            out = "Error Date";
        }else{
            int date = getInt(in.substring(6));
            int month = getInt(in.substring(4,6));
            int year = getInt(in.substring(0,4));
            if (year < 2400) {
                year += 543;
            }
            out = checkDate(date,month,year);
            if (out.equals("")) {
                out = convertDate(date,month,year,f_outDate,f_outMouth,f_outYear);
            }
        }
        return out;
    }

    private static String checkDate(int date, int month, int year) {
        String out = "";
        if (date < 1 && date > 31) {
            out = "Error day";
        }else if (month < 1 && date > 12) {
            out = "Error month";
        }else {
            Calendar c = Calendar.getInstance(new Locale("th","TH"));
            c.set(year,month - 1,1);
            if (c.getActualMaximum(Calendar.DAY_OF_MONTH) < date) {
                out = "Error day";
            }
        }
        return out;
    }
    
    private static String convertDate(int date, int month, int year, int f_outDate, int f_outMouth, int f_outYear) {
        String out = "";
        String d = getDate(date,f_outDate);
        String m = getMonth(month,f_outMouth);
        String y = getYear(year,f_outYear);
        if (f_outMouth == 1 || f_outMouth == 2) {
            out = d + "/" + m + "/" + y;
        }else {
            out = d + " " + m + " " + y;
        }
        return out;
    }

    private static String getDate(int date, int f_outDate) {
        String out = String.valueOf(date);
        if (f_outDate == 2 && date < 10) {
            out = paddingString(out,2,'0',true);
        }
        return out;
    }

    private static String getMonth(int month, int f_outMonth) {
        String out = String.valueOf(month);
        if (f_outMonth == 2 && month < 10) {
            out = paddingString(out,2,'0',true);
        }else if (f_outMonth == 3) {
            out = m1[month - 1];
        }else if (f_outMonth == 4) {
            out = m2[month - 1];
        }
        return out;
    }

    private static String getYear(int year, int f_year) {
        String out = String.valueOf(year);
        if (f_year == 1) {
            out = out.substring(2);
        }
        return out;
    }

    /**
    ** pad a string S with a size of N with char C
    ** on the left (True) or on the right(flase)
    **/
    private static String paddingString( String s, int n, char c , boolean paddingLeft  ) {
        StringBuffer str = new StringBuffer(s);
        int strLength  = str.length();
        if ( n > 0 && n > strLength ) {
          for ( int i = 0; i <= n ; i ++ ) {
                if ( paddingLeft ) {
                  if ( i < n - strLength ) str.insert( 0, c );
                }
                else {
                  if ( i > strLength ) str.append( c );
                }
          }
        }
        return str.toString();
    }

    private static int getInt(String in) {
        try {
            return Integer.parseInt(in);
        }catch (Exception e) {
            return 0;
        }
    }
    
	public static int getFiscalYear(Calendar calendar) {
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		if (month > 9) {
			year = year + 1;
		}
		return year;
	}
	
	public static Date toDate(String dateStr) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			throw e;
		}
	}
}
