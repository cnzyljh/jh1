package cn.rojao.util.authorize;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
 * 日期处理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    
    public static Date parseDate(String date, String pattern){
    	 SimpleDateFormat df = new SimpleDateFormat(pattern);
    	 try {
			return df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * java_时间戳与Date_相互转化相关函数
     * @param Unix
     * @return
     */
    public static String unixToDate(String Unix)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.parseLong(Unix)));
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static String dateToUnix()
    {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 获取一年后的当前系统时间
     * @return
     */
    public static Long OneYearLater()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, +1);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前系统时间 【Long】
     * @return
     */
    public static Long CurrentTime()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取100年后的当前系统时间
     * @return
     */
    public static Long OneHundredYearLater()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, +100);
        return calendar.getTimeInMillis();
    }

    /**
     * 接受YYYY-MM-DD的日期字符串参数,返回两个日期相差的天数
     * 
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static long getDistDates(String start, String end)
            throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(start);
        Date endDate = sdf.parse(end);
        return getDistDates(startDate, endDate);
    }

    /**
     * 返回两个日期相差的天数
     * 
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static long getDistDates(Date startDate, Date endDate)
    {
        int result = 0;
        if (startDate != null && endDate != null)
        {
            long timeFrom = startDate.getTime();
            long timeTo = endDate.getTime();
            result = (int) ((timeTo - timeFrom) / (1000 * 60 * 60 * 24));
        }
        return result;
    }

    /**
     * 将String类型的日期转换成Long类型
     * <p>
     * Title: getDate
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param date
     * @param parse
     * @return
     * @throws ParseException
     */
    public static long parseLongDate(String date, String parse)
            throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(parse);
        return sdf.parse(date).getTime();
    }

    /**
     * 将String类型的日期转换成Date类型，参数个数为yyyy-MM-dd
     * 
     * @param date
     * @param parse
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

    public static Date format(String dateStr, String pattern)
            throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }

    public static String format(Timestamp date, String pattern)
            throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 系统当天时间
     * 
     * @return
     */
    public static String getCurrentDate()
    {
        String curDate = null;
        try
        {
            curDate = format(new Date(), "yyyy-MM-dd");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return curDate;
    }

    public static String getCurrentTime()
    {
        String curDate = null;
        try
        {
            curDate = format(new Date(), "yyyy-MM-dd HH:mm:ss");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return curDate;
    }

    public static Date getCurrentDateYMD() throws ParseException
    {
        return parseDate(getCurrentDate());
    }

    /**
     * 增加天
     * 
     * @param date
     * @return
     */
    public static Date addDays(Date date, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, num);
        return c.getTime();
    }

    /**
     * 增加月
     * 
     * @param date
     * @return
     */
    public static Date addMonths(Date date, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, num);
        return c.getTime();
    }

    /**
     * 增加年
     * 
     * @param date
     * @return
     */
    public static Date addYears(Date date, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, num);
        return c.getTime();
    }

    /**
     * 增加时
     * 
     * @param date
     * @return
     */
    public static Date addHours(Date date, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, num);
        return c.getTime();
    }

    /**
     * 增加秒
     * 
     * @param date
     * @return
     */
    public static Date addSeconds(Date date, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, num);
        return c.getTime();
    }

    public static String getChinese(String date)
    {
        String cdate = null;
        if (date != null)
        {
            String oldPatten = "yyyy-MM-dd", newPatten = "yy年MM月dd日";
            if (date.length() >= 16)
            {
                oldPatten = "yyyy-MM-dd HH:mm";
                newPatten = "yy年M月d日H时m分";
            }
            SimpleDateFormat sdf1 = new SimpleDateFormat(oldPatten);
            SimpleDateFormat sdf2 = new SimpleDateFormat(newPatten);
            try
            {
                cdate = sdf2.format(sdf1.parse(date));
                cdate = cdate.replace("日0时0分", "日");
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return cdate;
    }

    /**
     * 获取HH:mm:ss时分秒的Long型
     * <p>
     * Title: getHMS
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param time
     * @return
     */
    public static long getHMS(String time)
    {
        if (time != null && time.length() > 0)
        {
            StringTokenizer token = new StringTokenizer(time, ":");

            int hourTime = Integer.parseInt(token.nextToken()) * 3600;
            int minute = Integer.parseInt(token.nextToken()) * 60;
            int second = Integer.parseInt(token.nextToken());

            return hourTime + minute + second;
        }
        return 0l;
    }

    /**
     * 根据Long型的时分秒格式化成HH:mm:ss
     * <p>
     * Title: getHMS
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param time
     * @return
     */
    public static String getHMS(Long time)
    {
        String timeStr = "";
        if (time != null)
        {
            long hour = time / 3600;
            if (hour < 10)
                timeStr += "0" + hour + ":";
            else
            {
                timeStr += hour + ":";
            }
            long minute = (time - hour * 3600) / 60;
            if (minute < 10)
                timeStr += "0" + minute + ":";
            else
            {
                timeStr += minute + ":";
            }
            long second = time - hour * 3600 - minute * 60;
            if (second < 10)
                timeStr += "0" + second;
            else
            {
                timeStr += second;
            }
        }
        else
        {
            timeStr = "00:00:00";
        }
        return timeStr;
    }

    public static String getCnHMS(Long time)
    {
        String timeStr = "";
        if (time != null)
        {
            long hour = time / 3600;
            if (hour > 0)
            {
                timeStr += hour + "时";
            }
            long minute = (time - hour * 3600) / 60;
            if (minute > 0)
            {
                timeStr += minute + "分";
            }
            long second = time - hour * 3600 - minute * 60;
            timeStr += second + "秒";
        }
        else
        {
            timeStr = "0秒";
        }
        return timeStr;
    }

    public static Date getDate(int month)
    {
        Calendar c = new GregorianCalendar();
        Date date = new Date();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    public static String getDateStr(long date)
    {
        String curDate = null;
        try
        {
            curDate = format(new Date(date), "yyyy-MM-dd");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return curDate;
    }

    public static Date getDate(long millis)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millis);
        Date date = c.getTime();
        return date;
    }

    public static String getCurrentYM()
    {
        String curDate = null;
        try
        {
            curDate = format(new Date(), "yyyy-MM");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return curDate;
    }

    /*
     * public static void main(String[] args) {
     * 
     * Calendar c = Calendar.getInstance();
     * System.out.println(c.get(Calendar.DAY_OF_MONTH));
     * System.out.println(c.get(Calendar.DAY_OF_WEEK));
     * System.out.println(c.get(Calendar.WEEK_OF_MONTH));
     * System.out.println(c.get(Calendar.WEEK_OF_YEAR));
     * System.out.println(c.get(Calendar.MONTH));
     * 
     * Date date = new Date(); SimpleDateFormat sdf = new
     * SimpleDateFormat("yyyy"); String str = sdf.format(date);
     * System.out.println(str);
     * 
     * }
     */
    /**
     * 取得当前日期是多少周
     * 
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);

        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到某一年周的总数
     * 
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year)
    {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

        return getWeekOfYear(c.getTime());
    }

    /**
     * 得到某年某周的第一天
     * 
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week)
    {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     * 
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week)
    {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得指定日期所在周的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 取得指定日期所在周的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 取得当前日期所在周的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek()
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek()
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     * @return
     */
    public static String getUTCTimeStr()
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance();
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        UTCTimeBuffer.append(year).append("-").append(month).append("-")
                .append(day);
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute);
        try
        {
            format.parse(UTCTimeBuffer.toString());
            return UTCTimeBuffer.toString();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static int getDiffTimeZoneRawOffset(String timeZoneId)
    {
        return TimeZone.getTimeZone("UTC").getRawOffset()
                - TimeZone.getTimeZone(timeZoneId).getRawOffset();
    }

    /**
     * 将UTC时间转换为东八区时间
     * @param utcTime
     * @param utcTimePatten (UTC时间格式) 类型为字符串，格式为"yyyy-MM-dd HH:mm"
     * @param localTimePatten (当前时间格式)
     * @return
     */
    public static String getLocalTimeFromUTC(String UTCTime)
            throws ParseException
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date UTCDate = null;
        String localTimeStr = null;
        UTCDate = format.parse(UTCTime);
        int diffTime = getDiffTimeZoneRawOffset(TimeZone.getDefault().getID());
        long nowTime = UTCDate.getTime();
        long newNowTime = nowTime - diffTime;
        UTCDate = new Date(newNowTime);
        localTimeStr = format.format(UTCDate);
        return localTimeStr;
    }
    
}
