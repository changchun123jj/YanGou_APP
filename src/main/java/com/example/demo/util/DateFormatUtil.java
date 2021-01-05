package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 日期格式化
 *
 * @author Administrator
 */
public class DateFormatUtil {

    /**
     * 转换日期为年月日时分秒的格式，暂时集成数据库这边会用。日期为字符串类型
     *
     * @param idatestr
     * @return
     * @throws ParseException
     */
    public static String formatDateString(String idatestr) throws ParseException {
        Date idate = null;
        if (StringUtils.isEmpty(idatestr)) {
            return "";
        }
        //判断具体是哪种格式，是则返回相应的标识为true
        boolean isSimple = isValidDate("yyyy-MM-dd HH:mm:ss", idatestr);
        boolean isEng = isValidDate("MM-dd-yyyy HH:mm:ss", idatestr);
        boolean isSt = isValidDate("yyyy-MM-dd'T'HH:mm:ss", idatestr);
        if (isSimple) {
            idate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(idatestr);
        } else if (isEng) {
            idate = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").parse(idatestr);
        } else if (isSt) {
            idate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(idatestr);
        }
        if (idate != null) {
            int year = idate.getYear() + 1900;
            int month = idate.getMonth() + 1;
            int day = idate.getDate();
            int hour = idate.getHours();
            int minute = idate.getMinutes();
            int seconds = idate.getSeconds();
            return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + seconds;
        } else {
            return "";
        }
    }

    /**
     * 将字符串日期转为真正的日期格式
     *
     * @param idatestr
     * @return
     * @throws ParseException
     */
    public static Date changeStringToDate(String idatestr) throws ParseException {
        Date idate = null;
        if ("".equals(idatestr)) {
            return null;
        }
        //判断具体是哪种格式，是则返回相应的标识为true
        boolean isSimple = isValidDate("yyyy-MM-dd HH:mm:ss", idatestr);
        boolean isSim = isValidDate("yyyy-MM-dd", idatestr);
        boolean isEng = isValidDate("MM-dd-yyyy HH:mm:ss", idatestr);
        boolean isSt = isValidDate("yyyy-MM-dd'T'HH:mm:ss", idatestr);
        boolean isSts = isValidDate("yyyy/MM/dd", idatestr);
        if (isSimple) {
            idate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(idatestr);
        } else if (isEng) {
            idate = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").parse(idatestr);
        } else if (isSt) {
            idate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(idatestr);
        } else if (isSts) {
            idate = new SimpleDateFormat("yyyy/MM/dd").parse(idatestr);
        } else if (isSim) {
            idate = new SimpleDateFormat("yyyy-MM-dd").parse(idatestr);
        }
        return idate;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 通过判断年月日计算两个时间相隔的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            return day2 - day1;
        }
    }

    /**
     * 判断传入的日期格式是否为yyyy-MM-dd HH:mm:ss这个格式
     *
     * @param formatStr 格式化字符串：设置最终要的日期格式
     * @param strDate   字符串日期
     * @return
     */
    public static boolean isValidDate(String formatStr, String strDate) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2018-02-29会被接受，并转换成2018-03-01

            format.setLenient(false);
            format.parse(strDate);

            // 判断传入的yyyy年-MM月-dd日 字符串是否为数字
//			String[] sArray = strDate.split("-");
//			for (String s : sArray) {
//				boolean isNum = s.matches("[0-9]+");
//				// +表示1个或多个（如"3"或"225"），*表示0个或多个（[0-9]*）（如""或"1"或"22"），?表示0个或1个([0-9]?)(如""或"7")
//				if (!isNum) {
//					return false;
//				}
//			}
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }

        return true;
    }

}
