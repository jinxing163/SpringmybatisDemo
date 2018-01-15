package com.ssm.baseTools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
* @ClassName: DateHelper
* @Description: 日期转换帮助类
* @author JinXing 
* @date 2017年10月25日 下午6:34:03
*
*/ 
public class DateHelper {

	/**
	* @Fields ONE_DAY : 一天之内
	*/ 
	public static final String ONE_DAY="oneDay";
	/**
	* @Fields TWO_DAY : 两天之内 （48小时以内）
	*/ 
	public static final String TWO_DAY="twoDay";
	/**
	* @Fields TWO_DAY : 十分钟之内 
	*/ 
	public static final String TEN_MIN="tenMin";
	/**
	* @Fields ONE_MONTH : 一个月之内
	*/ 
	public static final String ONE_MONTH="oneMonth";
	
	/**
	* @Fields unit_seconds : 单位 秒
	*/ 
	public static final String UNIT_SECONDS="seconds";
	
	/**
	* @Fields unit_minutes : 单位 分钟  
	*/ 
	public static final String UNIT_MINUTES="minutes";
	
	/**
	* @Fields unit_hours : 单位 小时
	*/ 
	public static final String UNIT_HOURS="hours";
	
	/**
	* @Fields unit_hours : 单位 小时
	*/ 
	public static final String UNIT_DAYS="days";
	
	
	/**
     * 获取某个时间之前的日期 
     * @Title: calculateTime
     * @author JinXing 
     * @date 2017年10月25日 下午6:36:15
     * @param  dateTime：twoDay、oneMonth （48小时、一个月以内）
     * @param 
     * @return Date
     */
    public static Long calculateTimeStamp(String dateTime) {
        if(dateTime!=null){
        	
        	Date calculateTime = calculateTime(dateTime);
        	if(calculateTime!=null){
        		return calculateTime.getTime();
        	}
        	
        }
        return null;
    } 
	
    /**
     * 获取某个时间之前的日期 
     * @Title: calculateTime
     * @author JinXing 
     * @date 2017年10月25日 下午6:36:15
     * @param  dateTime：twoDay、oneMonth （48小时、一个月以内）
     * @param 
     * @return Date
     */
    public static Date calculateTime(String dateTime) {
        Calendar now = Calendar.getInstance();
        if (ONE_DAY.equals(dateTime)) { 
            // in 24 hour 
            now.add(Calendar.DAY_OF_MONTH, -1);
        } else if (TWO_DAY.equals(dateTime)) { 
            // in 48 hour 
            now.add(Calendar.DAY_OF_MONTH, -2);
        } else if (TEN_MIN.equals(dateTime)) { 
            // in 48 hour 
            now.add(Calendar.MINUTE, -10);
        } else if (ONE_MONTH.equals(dateTime)) { 
            // in one month 
            now.add(Calendar.MONTH, -1);
        } else { 
            return null; 
        } 
        return now.getTime(); 
    } 
    
    /**
     * 计算指定时间戳之后的时间戳 （Long）
     * @Title: calculateAfterTime
     * @author JinXing 
     * @date 2017年11月7日 下午3:04:45
     * @param  unit  单位：时分秒 （UNIT_SECONDS、UNIT_MINUTES、UNIT_HOURS）
     * @param  timeInMillis 指定时间戳（为空为当前时间）
     * @param  number 计算多久之后的数值 （比如：单位秒，5秒后的时间）
     * @param @return
     * @return Date
     */
    public static Long calculateAfterTimeStamp(String unit, Long timeInMillis, Integer number) {
        if(unit!=null && number!=null){
        	
        	Date calculateTime = calculateAfterTime(unit,timeInMillis,number);
        	if(calculateTime!=null){
        		return calculateTime.getTime();
        	}
        	
        }
        return null;
    } 
    
    /**
     * 计算指定时间戳之后的时间 （Date）
     * @Title: calculateAfterTime
     * @author JinXing 
     * @date 2017年11月7日 下午3:04:45
     * @param  unit  单位：时分秒 （UNIT_SECONDS、UNIT_MINUTES、UNIT_HOURS）
     * @param  timeInMillis 指定时间戳（为空为当前时间）
     * @param  number 计算多久之后的数值 （比如：单位秒，5秒后的时间）
     * @param @return
     * @return Date
     */
    public static Date calculateAfterTime(String unit, Long timeInMillis, Integer number) {
        Calendar now = Calendar.getInstance();
        if(timeInMillis!=null){
        	now.setTimeInMillis(timeInMillis);//指定时间戳
        }
        
        if (UNIT_SECONDS.equals(unit)) { 
            // second
        	now.add(Calendar.SECOND, number);
        } else if (UNIT_MINUTES.equals(unit)) { 
        	// minute
        	now.add(Calendar.MINUTE, number);
        } else if (UNIT_HOURS.equals(unit)) { 
        	// hour
        	now.add(Calendar.HOUR, number);
        } else if (UNIT_DAYS.equals(unit)) { 
        	// day
        	now.add(Calendar.DAY_OF_YEAR, number);
        }  else { 
            return null; 
        } 
        return now.getTime(); 
    } 
    
    
    /**
     * 计算指定时间戳之前的时间戳 （Long）
     * @Title: calculateAfterTime
     * @author JinXing 
     * @date 2017年11月7日 下午3:04:45
     * @param  unit  单位：时分秒 （UNIT_SECONDS、UNIT_MINUTES、UNIT_HOURS）
     * @param  timeInMillis 指定时间戳（为空为当前时间）
     * @param  number 计算多久之后的数值 （比如：单位秒，5秒后的时间）
     * @param @return
     * @return Date
     */
    public static Long calculateBeforeTimeStamp(String unit, Long timeInMillis, Integer number) {
        if(unit!=null && number!=null){
        	
        	Date calculateTime = calculateBeforeTime(unit,timeInMillis,number);
        	if(calculateTime!=null){
        		return calculateTime.getTime();
        	}
        	
        }
        return null;
    } 
    
    /**
     * 计算指定时间戳之前的时间 （Date）
     * @Title: calculateAfterTime
     * @author JinXing 
     * @date 2017年11月7日 下午3:04:45
     * @param  unit  单位：时分秒 （UNIT_SECONDS、UNIT_MINUTES、UNIT_HOURS）
     * @param  timeInMillis 指定时间戳（为空为当前时间）
     * @param  number 计算多久之后的数值 （比如：单位秒，5秒后的时间）
     * @param @return
     * @return Date
     */
    public static Date calculateBeforeTime(String unit, Long timeInMillis, Integer number) {
        Calendar now = Calendar.getInstance();
        if(timeInMillis!=null){
        	now.setTimeInMillis(timeInMillis);//指定时间戳
        }
        
        if (UNIT_SECONDS.equals(unit)) { 
            // second
        	now.add(Calendar.SECOND, -number);
        } else if (UNIT_MINUTES.equals(unit)) { 
        	// minute
        	now.add(Calendar.MINUTE, -number);
        } else if (UNIT_HOURS.equals(unit)) { 
        	// hour
        	now.add(Calendar.HOUR, -number);
        } else if (UNIT_DAYS.equals(unit)) { 
        	// hour
        	now.add(Calendar.DAY_OF_YEAR, -number);
        }else { 
            return null; 
        } 
        return now.getTime(); 
    } 
	
    public static String DateToString(Date date){
    	
    	if(date !=null){
    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String dateStr = sdf.format(date);
        	
    		 return dateStr;
    	}
        return null;
    	
    }
    
    @SuppressWarnings("deprecation")
	public static Integer getNowHours(){
    	Calendar now = Calendar.getInstance();
    	return now.getTime().getHours();
    }
    
    /**
     * 获取当前字符时间：yyyy-MM-dd HH:mm:ss
     * @Title: getLocaleString
     * @author JinXing 
     * @date 2017年12月28日 下午5:20:50
     * @param @return
     * @return String
     */
    public static String getLocaleString(){
    	
    	Calendar now = Calendar.getInstance();
    	String dateToString = DateToString(now.getTime());
    	
		return dateToString;
    	
    }
    
    /**
     * String日期转Date日期
     * @Title: getStringToDate
     * @author JinXing 
     * @date 2018年1月3日 下午1:52:33
     * @param @param str
     * @param @return
     * @return Date
     */
    public static Date getStringToDate(String str){

    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Calendar calendar = Calendar.getInstance();
    	
    	Date date;
		try {
			
			date = sdf.parse(str);
			
			calendar.setTime(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

    	
		return calendar.getTime();
    	
    	
    }
    
    /**
     * 计算两个时间戳相差天数
     * @Title: differentDaysForLong
     * @author JinXing 
     * @date 2018年1月3日 下午1:54:25
     * @param  time1 时间戳:毫秒为单位
     * @param  time2 时间戳:毫秒为单位
     * @param @return
     * @return int
     */
    public static int differentDaysForLong(Long time1, Long time2) {
    	
    	Calendar calendar1 = Calendar.getInstance();
    	calendar1.setTimeInMillis(time1);
    	Date date1=calendar1.getTime();
    	
    	Calendar calendar2 = Calendar.getInstance();
    	calendar2.setTimeInMillis(time2);
    	Date date2=calendar2.getTime();
    	    	
		return differentDays(date1, date2);
    	
    }
    
	/**
     * 计算两个Date日期相差天数
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
		
		if (year1 != year2){// 同一年
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {// 闰年
					timeDistance += 366;
				} else {// 不是闰年
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		}else {// 不同年
			System.out.println("判断day2 - day1 : " + (day2 - day1));
			return day2 - day1;
		}
	}


    /**
     * 返回当前时间Date(不保留毫秒级单位)
     * 当前毫秒单位>0,当前时间自动+1秒
     * @return
     */
	public static Date getNewDate(){

        Calendar cal2 = Calendar.getInstance();
        int i = cal2.get(Calendar.MILLISECOND);
        cal2.get(Calendar.MILLISECOND);
        if(i >0){
            cal2.set(Calendar.MILLISECOND,0);
            cal2.add(Calendar.SECOND, 1);
        }else{
            cal2.set(Calendar.MILLISECOND,0);
        }

        return cal2.getTime();
    }

    public static Date getNewDateNoMillisecond(){

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.MILLISECOND,0);

        return cal2.getTime();
    }


}
