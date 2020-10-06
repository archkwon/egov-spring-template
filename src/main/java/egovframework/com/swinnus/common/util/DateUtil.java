/**
 * 날짜관련유틸
 * @package egovframework.com.swinnus.cmm.util
 * @file DateUtil.java
 * @author 권민관
 * @date 2015. 2. 9. 오전 9:27:46
 * @version 1.0 
 * @see
 *
 * <pre>
 
 *   수정일          수정자         수정내용 
 *  -------       --------     --------------------------- 
 *  2015. 2. 9.   권민관         최초 생성 
 * 
 * Copyright (C) 2015 by (주)에스위너스 All right reserved.
 *
 * </pre>
 */
package egovframework.com.swinnus.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static String getDate() throws Exception{
		return getDate(0L, "yyyyMMdd");
	}
	
	public static String getDateSplit() throws Exception{
		return getDate(0L, "yyyy-MM-dd");
	}

	public static String getDateTime() throws Exception{
		return getDate(0L, "yyyyMMddHHmmss");
	}

	public static String getDate(String formStr) throws Exception{
		return getDate(0L, formStr);
	}

	public static String getDate(long dayOffset, String formStr) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat(formStr);
		String dateStr = formatter.format(new Date(System.currentTimeMillis() + dayOffset * 0x5265c00L));
		return dateStr;
	}

	public static String getDate(Date today, String formStr) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat(formStr);
		String dateStr = formatter.format(today);
		return dateStr;
	}

	public static String getDate(Date today, long dayOffset, String formStr) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat(formStr);
		String dateStr = formatter.format(new Date(today.getTime() + dayOffset * 0x5265c00L));
		return dateStr;
	}
	
	public static Date getDate(String textDate, String formStr) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat(formStr);
		Date date = null;
		try {
			date = formatter.parse(textDate);
			
		} catch (ParseException e) {
		}
		return date;
	}
	
	public static String getDateSelect(int dateNum) throws Exception{
		Calendar calendar1 = new GregorianCalendar();
		calendar1.add(Calendar.DATE, dateNum);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(calendar1.getTime());
		return date;
	}
}
